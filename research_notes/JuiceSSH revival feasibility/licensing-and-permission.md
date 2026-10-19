# JuiceSSH successor: licensing and permission feasibility

Research date: 18 October 2026. Preliminary research, not legal clearance. EU/Czech law is a provisional working context; the developer's location, purchase jurisdiction, applicable contract and intended distribution territories remain unconfirmed. US distribution needs separate review. “Abandoned”, purchased Pro entitlement and unavailable billing are user-reported premises, not independently established facts. No application code was inspected or changed and no correspondence was sent.

## 1. Who can grant permission, and does abandonment or a Pro purchase change ownership?

### Takeaway

A paid entitlement is evidence relevant to lawful use, not ownership of the app's copyright or a permission to publish a fork. There is a credible contact route, and the relevant company-name match is currently active; neither inaccessible websites nor discontinued billing establishes that rights have ended.

### Cited Findings

- Sonelli's own GitHub organization identifies itself as **Sonelli Ltd**, London, UK, links `sonelli.com`, and publicly lists **support@sonelli.com**. It lists JuiceSSH plugins and a plugin library, and identifies GitHub user **PaulMaddox** under People. These are contact/association leads, not proof of an individual's authority to license all app rights. — [Sonelli organization](https://github.com/Sonelli)
- Companies House lists **SONELLI LTD, company 07878261**, incorporated 12 December 2011, as **Active**, with SIC 62012 (software development). Its registered office is **White Hackle Stonehill Crescent, Ottershaw, Chertsey, England, KT16 0EP**. This is a formal correspondence lead; the record does not establish ownership of JuiceSSH IP. — [Company record](https://find-and-update.company-information.service.gov.uk/company/07878261)
- The registry also returns **SONELLI SOFTWARE LTD, 09341155**, dissolved 26 April 2016. Do not substitute that similarly named company for SONELLI LTD or infer that JuiceSSH's owner was dissolved. — [Registry search](https://find-and-update.company-information.service.gov.uk/search?q=sonelli)
- The Software Directive protects program expression and reserves reproduction, adaptation and distribution, subject to specified exceptions. Exhaustion of distribution rights in a particular sold copy does not grant the separate reproduction/adaptation rights needed to publish a successor. — [Directive 2009/24/EC, Arts. 1, 4–6](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024)
- Czech copyright law distinguishes rights in a physical carrier from rights to use the work (§9), reserves uses to the rightsholder except statutory permissions (§12), and provides copyright terms (§27), rather than a general “unsupported software becomes free” rule. The text consulted is a **nonofficial reproduction of legislation**, not an official consolidated verification. — [Act 121/2000 Sb., §§9, 12, 27](https://www.zakonyprolidi.cz/cs/2000-121)
- The actual `Sonelli/juicessh-pluginlibrary` LICENSE is Apache License 2.0. Sections 2–4 grant rights in the licensed work subject to conditions, including license delivery, modified-file notices, retention of relevant notices and NOTICE obligations where applicable. Section 6 excludes a general trademark permission. This is evidence for that library, **not for the proprietary host app**. — [Actual library license](https://raw.githubusercontent.com/Sonelli/juicessh-pluginlibrary/master/LICENSE)
- Sonelli's organization labels Performance Monitor and Audit Log Apache-2.0, and lists other projects with different licenses, including GPL-3.0 projects. Those labels identify audit candidates; a release must check the exact files, dependencies and revision used. — [Sonelli repositories](https://github.com/Sonelli)

### Inferences

- **Recommended permission route:** email `support@sonelli.com`; if unanswered, use the registered office and/or ask the publicly linked GitHub member to route the request to the present rightsholder. Confirm identity and signing authority, copyright assignments, contractor/contributor rights and any asset-specific limitations before relying on a grant. A support reply is not necessarily a complete IP license. [Contact evidence](https://github.com/Sonelli); [company evidence](https://find-and-update.company-information.service.gov.uk/company/07878261)
- Treat a shutdown, lack of response, or a missing store page as operational evidence only. Keep code, brand and asset rights reserved unless a permission or applicable statutory exception is actually established. [Directive, Arts. 4–6](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024)
- Open-source plugins may provide an independently licensed starting point for compatibility research. Their licenses do not authorize decompiling and relicensing the host app, copying its resources, or presenting a new app as official JuiceSSH. [Library license, §§1–6](https://raw.githubusercontent.com/Sonelli/juicessh-pluginlibrary/master/LICENSE)

### Gaps

- **Actual proprietary terms not recovered.** Fetches of [juicessh.com](https://juicessh.com), the candidate path [juicessh.com/terms](https://juicessh.com/terms), and [sonelli.com](https://sonelli.com) returned transport errors. The candidate terms path is not a verified historical EULA location. No terms clauses, governing-law clause or reverse-engineering ban are asserted here.
- The [Google Play package URL](https://play.google.com/store/apps/details?id=com.sonelli.juicessh&hl=en) returned 404 through this research tool. That does not prove global delisting, a shutdown date, or the cause of the user's billing failure.
- Obtain the purchaser's receipt, purchase-date EULA/store terms, exact app/version and legitimate acquisition record, in-app legal notices and any prior support correspondence. Do not publish receipt/account secrets in the research record.
- No archived official terms, corporate IP assignments, complete contributor agreements, app source license, trademark registrations, or rights-transfer announcements were recovered. Mailbox deliverability and present willingness to license are untested. Public repository update dates do not establish continued maintenance of the main app.

## 2. What research, repair and successor implementation routes are defensible in principle?

### Takeaway

An independently implemented, independently branded client based on lawful observation and properly licensed components is the strongest practical route to investigate. Necessary private error correction and narrowly scoped interoperability decompilation can have statutory foundations, but neither is a general permission to release a decompiled fork or universal Pro unlocker.

### Cited Findings

- **Lawful observation:** Directive Art. 5(3) permits a person entitled to use a copy to observe, study and test its operation during acts they are entitled to perform. Art. 8(2) voids contractual terms contrary to Art. 6 or Arts. 5(2)–(3). This is not unrestricted authorization for every act described as reverse engineering. — [Directive 2009/24/EC](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024)
- **Interoperability decompilation:** Art. 6 requires a lawful user or authorized person acting on their behalf; indispensable information not already readily available; and work limited to the necessary program parts. The results may only serve interoperability of an independently created program, may only be shared when necessary for that interoperability, and may not be used to produce a program substantially similar in protected expression. — [Directive, Art. 6](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024)
- **Functionality versus copying:** In *SAS Institute v World Programming*, the CJEU held functionality, programming language and data-file formats are not expression of a computer program protected as such under the Software Directive. It distinguished lawful behavioral reimplementation from taking source/object code; original expression in manuals and other works can remain protected. Paragraphs 43–45 specifically limit overbroad readings of the functionality holding. — [C-406/10, paras. 39–46, 49–61, 63–70](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62010CJ0406)
- **Error correction is a different route:** *Top System* permits necessary decompilation by a lawful purchaser to correct operational errors, including disabling a defective function. It does not require meeting the interoperability exception, but requires necessity and compliance with applicable contractual arrangements. The parties cannot prohibit all error correction, although they can organize how it is performed. Results cannot be reused for unrelated purposes; the judgment expressly addresses continuing reproduction and distribution restrictions. — [C-13/20, paras. 57–74 and operative ruling](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62020CJ0013)
- **Czech implementation:** §65 protects program expression, not underlying ideas/principles. §66(1)(a) covers necessary use/loading/running and error correction; (d) covers observation/testing; (e) covers necessary interoperability code reproduction/translation; §66(4) limits use and sharing of the information; §66(6) identifies lawful users and protects the minimum statutory scope, with an exception for (1)(b). — [Act 121/2000 Sb., §§65–66, nonofficial consolidated reproduction](https://www.zakonyprolidi.cz/cs/2000-121#p66)
- **Czech technical-protection nuance:** §66(7) expressly disapplies selected general provisions, including §43(1), to computer programs; §66(8) preserves necessary observation/interoperability limitations and requires access for lawful users within the statutory scope. Do not simply import the US DMCA or a generic EU media-DRM rule into Czech software analysis. Tool distribution and mixed program/assets protection still require specific review. At EU level, Software Directive Art. 7(1)(c) addresses circulating or commercially possessing means whose sole intended purpose is facilitating unauthorized removal/circumvention of software protection. — [Czech §§43, 66(7)–(8)](https://www.zakonyprolidi.cz/cs/2000-121#p66); [Directive Art. 7](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024)
- **UI is not automatically free to clone:** *BSA v Ministerstvo kultury*, a Czech reference, holds a GUI is not program expression under the Software Directive but may be independently copyright-protected if original. Arrangement/configuration matters; elements dictated solely by technical function do not satisfy originality on that basis. — [C-393/09, paras. 35–51](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62009CJ0393)
- **Other rights survive:** the Software Directive leaves trademark, unfair-competition, patent, trade-secret and contract law intact. Apache-2.0's own trademark exclusion further illustrates why a code license is not brand clearance. — [Directive Art. 8(1)](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024); [library license §6](https://raw.githubusercontent.com/Sonelli/juicessh-pluginlibrary/master/LICENSE)
- **US copyright:** 17 USC §106 reserves reproduction, derivative works and distribution. Section 117 has limited copy-owner use/archive permissions and requires copyright-owner authorization to transfer adaptations made under that section. A purchased entitlement does not by itself settle the statutory “owner of a copy” question. — [§106](https://www.law.cornell.edu/uscode/text/17/106); [§117](https://www.law.cornell.edu/uscode/text/17/117)
- **US circumvention:** §1201(a)(1) addresses access-control circumvention; (a)(2) and (b) separately address trafficking in circumvention technology. Section 1201(f) supplies a conditional interoperability route for independently created programs, not an unrestricted entitlement-restoration exception. Triennial exemptions under (a)(1) do not automatically defend other claims: see (a)(1)(E). Copyright fair use and circumvention must be analyzed separately. — [17 USC §1201(a)–(c), (f)](https://www.law.cornell.edu/uscode/text/17/1201)
- **US brand/presentation:** false origin, sponsorship or affiliation representations likely to confuse can create liability, and the statute addresses unregistered trade dress as well. An absence of a discovered trademark registration is not a complete clearance. — [15 USC §1125(a)](https://www.law.cornell.edu/uscode/text/15/1125)

### Inferences

| Proposed activity | Provisional assessment and gate |
|---|---|
| Observe a legitimately acquired copy; implement equivalent SSH features from specifications and one's own code | Best starting route. Establish lawful use; record provenance; independently design expression. *SAS* supports functionality reimplementation, not copying protected code/manuals. |
| Decode an export format or implement plugin interoperability | Define the actual independent program and information-exchange objective. First use published documentation and licensed SDK/plugin code. Document missing information and why any decompilation is indispensable; limit disclosure to what is necessary. |
| Repair the purchaser's own lost Pro access | Potential error-correction argument, not a conclusion. Verify the purchased entitlement, intended use, failure mechanism and necessity. A remote billing/service discontinuation is not automatically a program error within *Top System*. |
| Publish a repair patch or unlock tool | Separate assessment even if personal repair is defensible. A patch may contain protected material and/or be a circumvention tool; “patch only” does not settle legality. Recipient ownership checks do not supply app-distribution rights. |
| Rebuild and distribute a decompiled APK | Do not release on the present evidence. It retains protected expression; obtain sufficient permission or a specifically established legal basis for each relevant act. Renaming symbols, translating languages, or having AI rewrite decompiled methods does not establish independent creation. |
| Release a clean-room successor with original UI and name | Plausible path, contingent on documented independent creation, component-license compliance, branding review and territory-specific advice. “Clean room” is an evidentiary process, not a statutory safe harbor. |

The table is project-specific inference from [Directive Arts. 4–8](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024), [SAS](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62010CJ0406), [Top System](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62020CJ0013), and [17 USC §1201](https://www.law.cornell.edu/uscode/text/17/1201), not a judicial conclusion about JuiceSSH.

- **Suggested clean-room evidence:** a lawful-observation/specification record; interface facts separated from proprietary code and screenshots; implementation by people without access to decompiled expression where feasible; original test fixtures and assets; contributor exposure declarations; and file-level provenance. If developers or AI contexts already saw decompiled code, document that exposure rather than retroactively calling the work clean-room. Decide with counsel whether a fresh implementation boundary is needed. This is risk-management inference from the expression/independence distinctions in [SAS](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62010CJ0406) and [Art. 6](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024).
- **Keep repair-tool licensing distinct:** an MIT/Apache/GPL notice from the author of a billing fix grants only rights they possess in that fix. It cannot grant Sonelli's app rights, erase copied app material, authorize the brand, or resolve circumvention restrictions. No particular bypass repository or its license was supplied or audited. [Directive Art. 4](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024); [Apache work/contribution definitions and grant](https://raw.githubusercontent.com/Sonelli/juicessh-pluginlibrary/master/LICENSE); [§1201](https://www.law.cornell.edu/uscode/text/17/1201)
- Use original artwork, icons, copy, layouts and translations unless their actual licenses or permissions are verified. “Same workflow” and “same pixels/assets” are different legal questions. Choose a distinct product name; consider a limited truthful compatibility reference only after trademark review, rather than treating “unofficial JuiceSSH” as an automatic cure. [BSA](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62009CJ0393); [SAS](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62010CJ0406); [§1125](https://www.law.cornell.edu/uscode/text/15/1125)

### Gaps

- The official [e-Sbírka entry](https://www.e-sbirka.cz/sb/2000/121) returned only an application shell. Czech text above was checked against Zákony pro lidi, which displayed a version effective 1 July 2025. Counsel should verify the official consolidation effective at the relevant act/date. EU legislation and CJEU judgments were accessed on official EUR-Lex; US statutory text was accessed through Cornell LII, a nonofficial publisher of primary statutory material.
- No case was located deciding this particular JuiceSSH billing failure. No technical examination established whether the restriction is broken local entitlement verification, deliberate expiry, inaccessible remote functionality or something else.
- No US case-law/circuit-specific reverse-engineering or contract analysis, current triennial exemption fit, EU/Czech trademark-register search, patent search, UK legal analysis, or store-distribution policy audit was completed. None should be implied by these notes. A UK company lead makes UK contractual/ownership issues relevant even if development occurs in Czechia.
- Exact asset originality, SDK scope, plugin dependencies, contributed translations, main-app third-party components and any existing bypass tool need a separate provenance/license inventory. A public GitHub repository without an applicable license is not presumed reusable.

## 3. What are the practical gates and the permission request?

### Takeaway

Proceed with a documented independent-rewrite assessment and a targeted permission request. Keep a decompiled public fork, copied branding/assets and public entitlement-bypass distribution behind unresolved rights gates; a nonresponse is not a grant.

### Cited Findings

- A useful permission agreement must match the separate acts of reproduction, modification and distribution rather than merely granting “maintenance.” — [Directive Art. 4](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024); [17 USC §106](https://www.law.cornell.edu/uscode/text/17/106)
- Open-source redistribution obligations and brand permissions are separate even under the actual Sonelli plugin-library license. — [Apache-2.0 §§2–6](https://raw.githubusercontent.com/Sonelli/juicessh-pluginlibrary/master/LICENSE)
- The verified first contact lead is `support@sonelli.com`; company record 07878261 supplies a formal fallback. — [Sonelli GitHub](https://github.com/Sonelli); [Companies House](https://find-and-update.company-information.service.gov.uk/company/07878261)

### Inferences

#### Practical decision gates

These are recommendations derived from the authorities in sections 1–2, not additional legal permissions.

1. **Facts and jurisdiction gate:** establish developer/publisher locations, distribution territories, exact purchased entitlement, acquisition source/version, applicable terms and documented failure. Preserve purchase/support evidence. Resolve whether the goal is personal restoration, a patch service, a new client or distribution of a modified app.
2. **Rights-holder gate:** ask Sonelli to identify the present owner(s) and authorized signatory. For a fork, obtain an executed grant covering the exact source/binary versions, adaptation, public source/binary distribution, commercial/noncommercial use, territories, downstream rights and intended open-source license. Confirm third-party exclusions and contributor authority.
3. **Research-method gate:** start with public protocols, licensed SDKs and lawful black-box observation. Before decompilation, record the specific legal route, necessity, scope, contractual constraints and permitted recipients. Do not reuse error-correction output to bootstrap a commercial clone without a separate basis.
4. **Entitlement-repair gate:** obtain advice on the precise repair and technical-protection regime before treating a bypass as permitted. Assess private repair, distribution of a patch and distribution of a modified APK separately, including US §1201 where relevant.
5. **Release-content gate:** audit every code/resource/dependency origin and license; independently implement unlicensed functionality; replace unlicensed assets; review the UI for copied original expression. Keep restrictive research artifacts out of public release materials where their disclosure is not authorized.
6. **Brand gate:** use a cleared independent name/logo or obtain an express trademark license with approved presentation and quality-control terms. Verify any “successor,” “official,” or compatibility statements; do not assume a code release grants these.
7. **Distribution gate:** obtain counsel's scoped assessment for the actual territories and artifact, plus platform-policy and open-source compliance review. An EU research exception does not establish US release clearance. Recheck current law and permissions at release.

**Practical route ranking:** independently branded rewrite with auditable inputs → authorized source-based revival if Sonelli grants sufficient rights → narrow personal repair subject to its own assessment. A publicly distributed decompiled fork or broad unlocker has no established release basis in this record. This ranking follows the independence and restricted-purpose requirements in [Directive Arts. 4–6](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32009L0024), [Top System](https://eur-lex.europa.eu/legal-content/EN/TXT/HTML/?uri=CELEX:62020CJ0013), and [§1201](https://www.law.cornell.edu/uscode/text/17/1201).

#### Draft permission email — NOT SENT

To: support@sonelli.com  
Subject: JuiceSSH maintenance/successor project — rights-holder and permission inquiry

Hello Sonelli team,

I am a JuiceSSH user who purchased Pro. I currently cannot restore/use the purchased entitlement through the available billing flow. I can provide the receipt and exact version privately. Could you advise whether there is an official restoration method and whether JuiceSSH maintenance is continuing?

I am also exploring a community-maintained Android SSH client or an authorized continuation of JuiceSSH. Before using any proprietary material, I would like to identify the current copyright and trademark owner(s), and the person authorized to discuss a written license. If that is no longer Sonelli Ltd, could you direct me to the appropriate party?

Would you be willing to discuss permission covering some or all of the following, with the scope and exclusions recorded explicitly?

1. **Code and builds:** access to the relevant source, build scripts and documentation; permission to study, reproduce, modify, maintain and distribute identified versions and derivatives in source and binary form, including Android modernization and security fixes. If source is unavailable, please specify whether and to what extent reverse engineering or decompiled material may be used.
2. **Purchased Pro restoration:** an official offline restoration method or express authorization for a defined repair for verified purchasers. Please distinguish permission for personal repair, distributing a repair tool, and distributing modified app builds, and identify what authorization you can grant concerning billing/activation components and third-party services.
3. **Assets and documentation:** whether icons, graphics, layouts, themes, fonts, text, screenshots, documentation and translations may be reused and modified, with an inventory of third-party or contributor-owned exclusions and required credits.
4. **Name and brand:** whether the JuiceSSH name, logo and related marks may be used for an authorized continuation, under what quality controls, attribution and endorsement wording. If not, we would use a different brand and seek agreement on any compatibility reference.
5. **Plugins and interoperability:** confirmation of the licenses and scope for the plugin library, APIs, official plugins and examples; any additional interface/export-format documentation; and permission for a replacement host to interoperate with existing plugins and user exports. Please identify separately owned components or service dependencies.
6. **Open-source release:** whether Sonelli can authorize release of its owned contributions under a named OSI-approved license, such as Apache-2.0 if compatible with the included dependencies, with downstream modification, redistribution and commercial-use rights. Please identify contributor consents or third-party approvals required and any assets or trademarks excluded from that release.
7. **Scope and authority:** the applicable versions/materials, territories (including EU and US), duration, termination terms, sublicensing/downstream grants, relevant patent rights, attribution, and confirmation of the signatory's authority and any previous IP transfers. Any app-store listing or signing arrangement would be discussed separately through an appropriate transfer process.

We would be happy to start with a narrower maintenance or interoperability agreement if a full source release is not possible. We will not interpret silence as permission. Could you let me know who should receive a more detailed proposal?

Thank you,

[Name]  
[Contact information]  
[Proposed project/repository, if appropriate]

### Gaps

- The email is an inquiry draft, not a license instrument and not a representation that any requested right exists or can be granted by Sonelli alone. It has not been sent.
- No permission has been obtained, and no successor artifact has been reviewed for release. The strongest next evidence is the actual purchase terms/entitlement record, a response from an authorized rightsholder, and a scoped Czech/EU plus relevant distribution-territory legal assessment.
