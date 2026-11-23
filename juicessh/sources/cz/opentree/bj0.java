package cz.opentree;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Book;
import cz.opentree.juicessh.views.CardListItem;
import cz.opentree.pi0;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: BookclubFragment.java */
/* loaded from: classes.dex */
public class bj0 extends Fragment implements CardListItem.OnClickListener {

    /* renamed from: O */
    public ListView f1743O;

    /* renamed from: P */
    public View f1744P;

    /* renamed from: Q */
    public View f1745Q;

    /* renamed from: R */
    public final gh0 f1746R = new gh0();

    /* compiled from: BookclubFragment.java */
    /* renamed from: cz.opentree.bj0$a */
    /* loaded from: classes.dex */
    public class C0780a extends pi0.AbstractC1716l {

        /* renamed from: a */
        public final /* synthetic */ LayoutInflater f1747a;

        /* compiled from: BookclubFragment.java */
        /* renamed from: cz.opentree.bj0$a$a */
        /* loaded from: classes.dex */
        public class a implements Comparator<Book> {
            public a(C0780a c0780a) {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Book book, Book book2) {
                return String.CASE_INSENSITIVE_ORDER.compare(book.m5453d(), book2.m5453d());
            }
        }

        /* compiled from: BookclubFragment.java */
        /* renamed from: cz.opentree.bj0$a$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://juicessh.com/bookclub"));
                intent.addFlags(1074266112);
                bj0.this.startActivity(intent);
            }
        }

        /* compiled from: BookclubFragment.java */
        /* renamed from: cz.opentree.bj0$a$c */
        /* loaded from: classes.dex */
        public class c implements View.OnClickListener {

            /* renamed from: O */
            public final /* synthetic */ Book f1750O;

            public c(Book book) {
                this.f1750O = book;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qi0.m7716c(bj0.this.getActivity()).m7717a("Bookclub", "Clickthrough", this.f1750O.m5453d());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f1750O.m5454e()));
                intent.addFlags(1074266112);
                try {
                    bj0.this.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(bj0.this.getActivity(), bj0.this.getString(R.string.an_error_has_occurred), 0).show();
                }
            }
        }

        /* compiled from: BookclubFragment.java */
        /* renamed from: cz.opentree.bj0$a$d */
        /* loaded from: classes.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bj0.this.m2527k();
            }
        }

        public C0780a(LayoutInflater layoutInflater) {
            this.f1747a = layoutInflater;
        }

        @Override // cz.opentree.pi0.AbstractC1716l
        /* renamed from: a */
        public void mo2528a() {
            super.mo2528a();
            bj0.this.f1743O.setVisibility(8);
            bj0.this.f1745Q.setVisibility(8);
            bj0.this.f1744P.setVisibility(0);
            ((TextView) bj0.this.f1744P.findViewById(R.id.error_message)).setText(R.string.please_try_again_later);
            bj0.this.f1744P.setOnClickListener(null);
        }

        @Override // cz.opentree.pi0.AbstractC1716l
        /* renamed from: b */
        public void mo2529b() {
            super.mo2529b();
            bj0.this.f1743O.setVisibility(8);
            bj0.this.f1745Q.setVisibility(8);
            bj0.this.f1744P.setVisibility(0);
            ((TextView) bj0.this.f1744P.findViewById(R.id.error_message)).setText(R.string.tap_to_retry);
            bj0.this.f1744P.setOnClickListener(new d());
        }

        @Override // cz.opentree.pi0.AbstractC1716l
        /* renamed from: c */
        public void mo2530c(List<Book> list) {
            super.mo2530c(list);
            Collections.sort(list, new a(this));
            if (bj0.this.getActivity() == null || bj0.this.getActivity().isFinishing()) {
                return;
            }
            bj0.this.f1746R.m4135b();
            CardListItem cardListItem = new CardListItem(bj0.this.getActivity(), -2);
            cardListItem.m5678t(bj0.this.getString(R.string.about));
            LinearLayout linearLayout = (LinearLayout) this.f1747a.inflate(R.layout.bookclub_card_content, (ViewGroup) null, false);
            ((TextView) linearLayout.findViewById(R.id.description)).setText(bj0.this.getString(R.string.bookclub_description));
            cardListItem.m5665g().setVisibility(8);
            cardListItem.m5664f().setVisibility(8);
            cardListItem.m5667i().setVisibility(8);
            cardListItem.m5673o(linearLayout);
            cardListItem.m5672n(bj0.this.getString(R.string.suggest_more_books));
            cardListItem.m5671m(new b());
            bj0.this.f1746R.m4134a(cardListItem);
            int i = 0;
            for (Book book : list) {
                CardListItem cardListItem2 = new CardListItem(bj0.this.getActivity(), i);
                i++;
                cardListItem2.m5678t(book.m5453d());
                cardListItem2.m5677s(book.m5450a());
                cardListItem2.m5674p(R.string.icon_book);
                Picasso.m10676n(bj0.this.getActivity()).m10685j(book.m5452c()).m9309g(cardListItem2);
                LinearLayout linearLayout2 = (LinearLayout) this.f1747a.inflate(R.layout.bookclub_card_content, (ViewGroup) null, false);
                TextView textView = (TextView) linearLayout2.findViewById(R.id.description);
                textView.setText(Html.fromHtml(book.m5451b()));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setLines(10);
                cardListItem2.m5673o(linearLayout2);
                cardListItem2.m5672n(bj0.this.getString(R.string.more_information));
                cardListItem2.m5671m(new c(book));
                bj0.this.f1746R.m4134a(cardListItem2);
            }
            bj0.this.f1745Q.setVisibility(8);
            bj0.this.f1744P.setVisibility(8);
            bj0.this.f1743O.setVisibility(0);
        }
    }

    @Override // cz.opentree.juicessh.views.CardListItem.OnClickListener
    /* renamed from: g */
    public void mo2526g(int i) {
    }

    /* renamed from: k */
    public final void m2527k() {
        this.f1743O.setVisibility(8);
        this.f1744P.setVisibility(8);
        this.f1745Q.setVisibility(0);
        pi0.m7328g(getActivity(), new C0780a((LayoutInflater) getActivity().getSystemService("layout_inflater")));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.card_list, viewGroup, false);
        this.f1745Q = inflate.findViewById(R.id.loading_layout);
        this.f1744P = inflate.findViewById(R.id.error_layout);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        this.f1743O = listView;
        listView.setAdapter((ListAdapter) this.f1746R);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m2527k();
    }
}
