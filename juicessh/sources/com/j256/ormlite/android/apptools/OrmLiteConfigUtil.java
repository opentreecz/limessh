package com.j256.ormlite.android.apptools;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.p001db.SqliteAndroidDatabaseType;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class OrmLiteConfigUtil {
    public static final String RAW_DIR_NAME = "raw";
    public static final String RESOURCE_DIR_NAME = "res";
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    public static int maxFindSourceLevel = 20;

    private static boolean classHasAnnotations(Class<?> cls) {
        while (cls != null) {
            if (cls.getAnnotation(DatabaseTable.class) != null) {
                return true;
            }
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.getAnnotation(DatabaseField.class) != null || field.getAnnotation(ForeignCollectionField.class) != null) {
                        return true;
                    }
                }
                try {
                    cls = cls.getSuperclass();
                } catch (Throwable th) {
                    System.err.println("Could not get super class for: " + cls);
                    System.err.println("     " + th);
                    return false;
                }
            } catch (Throwable th2) {
                System.err.println("Could not load get delcared fields from: " + cls);
                System.err.println("     " + th2);
            }
        }
        return false;
    }

    private static void findAnnotatedClasses(List<Class<?>> list, File file, int i) throws SQLException, IOException {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                if (i < maxFindSourceLevel) {
                    findAnnotatedClasses(list, file2, i + 1);
                }
            } else if (file2.getName().endsWith(".java")) {
                String packageOfClass = getPackageOfClass(file2);
                if (packageOfClass == null) {
                    System.err.println("Could not find package name for: " + file2);
                } else {
                    try {
                        Class<?> cls = Class.forName(packageOfClass + "." + file2.getName().substring(0, r6.length() - 5));
                        if (classHasAnnotations(cls)) {
                            list.add(cls);
                        }
                        try {
                            for (Class<?> cls2 : cls.getDeclaredClasses()) {
                                if (classHasAnnotations(cls2)) {
                                    list.add(cls2);
                                }
                            }
                        } catch (Throwable th) {
                            System.err.println("Could not load inner classes for: " + cls);
                            System.err.println("     " + th);
                        }
                    } catch (Throwable th2) {
                        System.err.println("Could not load class file for: " + file2);
                        System.err.println("     " + th2);
                    }
                }
            }
        }
    }

    public static File findRawDir(File file) {
        for (int i = 0; file != null && i < 20; i++) {
            File findResRawDir = findResRawDir(file);
            if (findResRawDir != null) {
                return findResRawDir;
            }
            file = file.getParentFile();
        }
        return null;
    }

    private static File findResRawDir(File file) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().equals(RESOURCE_DIR_NAME) && file2.isDirectory()) {
                File[] listFiles = file2.listFiles(new FileFilter() { // from class: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file3) {
                        return file3.getName().equals(OrmLiteConfigUtil.RAW_DIR_NAME) && file3.isDirectory();
                    }
                });
                if (listFiles.length == 1) {
                    return listFiles[0];
                }
            }
        }
        return null;
    }

    private static String getPackageOfClass(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return null;
                }
                if (readLine.contains("package")) {
                    String[] split = readLine.split("[ \t;]");
                    if (split.length > 1 && split[0].equals("package")) {
                        return split[1];
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            throw new IllegalArgumentException("Main can take a single file-name argument.");
        }
        writeConfigFile(strArr[0]);
    }

    public static void writeConfigFile(File file) throws SQLException, IOException {
        writeConfigFile(file, new File("."));
    }

    public static void writeConfigFile(File file, File file2) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file2, 0);
        writeConfigFile(file, (Class<?>[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(File file, Class<?>[] clsArr) throws SQLException, IOException {
        System.out.println("Writing configurations to " + file.getAbsolutePath());
        writeConfigFile(new FileOutputStream(file), clsArr);
    }

    public static void writeConfigFile(OutputStream outputStream, File file) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file, 0);
        writeConfigFile(outputStream, (Class<?>[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr) throws SQLException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
        try {
            writeHeader(bufferedWriter);
            for (Class<?> cls : clsArr) {
                writeConfigForTable(bufferedWriter, cls);
            }
            System.out.println("Done.");
        } finally {
            bufferedWriter.close();
        }
    }

    public static void writeConfigFile(String str) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, new File("."), 0);
        writeConfigFile(str, (Class<?>[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(String str, Class<?>[] clsArr) throws SQLException, IOException {
        File findRawDir = findRawDir(new File("."));
        if (findRawDir == null) {
            System.err.println("Could not find raw directory");
        } else {
            writeConfigFile(new File(findRawDir, str), clsArr);
        }
    }

    private static void writeConfigForTable(BufferedWriter bufferedWriter, Class<?> cls) throws SQLException, IOException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                for (Field field : cls2.getDeclaredFields()) {
                    DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(databaseType, extractTableName, field);
                    if (fromField != null) {
                        arrayList.add(fromField);
                    }
                }
            } catch (Error e) {
                System.err.println("Skipping " + cls + " because we got an error finding its definition: " + e.getMessage());
                return;
            }
        }
        if (arrayList.isEmpty()) {
            System.out.println("Skipping " + cls + " because no annotated fields found");
            return;
        }
        DatabaseTableConfigLoader.write(bufferedWriter, new DatabaseTableConfig(cls, extractTableName, arrayList));
        bufferedWriter.append("#################################");
        bufferedWriter.newLine();
        System.out.println("Wrote config for " + cls);
    }

    private static void writeHeader(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.append('#');
        bufferedWriter.newLine();
        bufferedWriter.append("# generated on ").append((CharSequence) new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
        bufferedWriter.newLine();
        bufferedWriter.append('#');
        bufferedWriter.newLine();
    }
}
