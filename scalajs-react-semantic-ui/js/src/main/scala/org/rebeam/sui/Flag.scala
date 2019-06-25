
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Flag {
  
  sealed trait Name{ val value: String }

  object Name {
    case object Va extends Name { val value: String = "va" }
    case object Ci extends Name { val value: String = "ci" }
    case object AlandIslands extends Name { val value: String = "aland islands" }
    case object Zm extends Name { val value: String = "zm" }
    case object Bm extends Name { val value: String = "bm" }
    case object Lr extends Name { val value: String = "lr" }
    case object Finland extends Name { val value: String = "finland" }
    case object Aw extends Name { val value: String = "aw" }
    case object NorthKorea extends Name { val value: String = "north korea" }
    case object Brunei extends Name { val value: String = "brunei" }
    case object By extends Name { val value: String = "by" }
    case object Nl extends Name { val value: String = "nl" }
    case object Tv extends Name { val value: String = "tv" }
    case object Si extends Name { val value: String = "si" }
    case object Colombia extends Name { val value: String = "colombia" }
    case object Ve extends Name { val value: String = "ve" }
    case object Fj extends Name { val value: String = "fj" }
    case object Iraq extends Name { val value: String = "iraq" }
    case object Az extends Name { val value: String = "az" }
    case object Reunion extends Name { val value: String = "reunion" }
    case object Ax extends Name { val value: String = "ax" }
    case object Zambia extends Name { val value: String = "zambia" }
    case object SanMarino extends Name { val value: String = "san marino" }
    case object UnitedStates extends Name { val value: String = "united states" }
    case object Bo extends Name { val value: String = "bo" }
    case object Ws extends Name { val value: String = "ws" }
    case object Pw extends Name { val value: String = "pw" }
    case object Moldova extends Name { val value: String = "moldova" }
    case object SaintHelena extends Name { val value: String = "saint helena" }
    case object To extends Name { val value: String = "to" }
    case object Kg extends Name { val value: String = "kg" }
    case object Mv extends Name { val value: String = "mv" }
    case object Namibia extends Name { val value: String = "namibia" }
    case object Sweden extends Name { val value: String = "sweden" }
    case object SaintLucia extends Name { val value: String = "saint lucia" }
    case object Slovenia extends Name { val value: String = "slovenia" }
    case object Dk extends Name { val value: String = "dk" }
    case object Romania extends Name { val value: String = "romania" }
    case object Dz extends Name { val value: String = "dz" }
    case object Bangladesh extends Name { val value: String = "bangladesh" }
    case object FalklandIslands extends Name { val value: String = "falkland islands" }
    case object Lebanon extends Name { val value: String = "lebanon" }
    case object Thailand extends Name { val value: String = "thailand" }
    case object Fi extends Name { val value: String = "fi" }
    case object Netherlands extends Name { val value: String = "netherlands" }
    case object Latvia extends Name { val value: String = "latvia" }
    case object Ethiopia extends Name { val value: String = "ethiopia" }
    case object Rs extends Name { val value: String = "rs" }
    case object Liberia extends Name { val value: String = "liberia" }
    case object Tajikistan extends Name { val value: String = "tajikistan" }
    case object Tf extends Name { val value: String = "tf" }
    case object Uganda extends Name { val value: String = "uganda" }
    case object Spain extends Name { val value: String = "spain" }
    case object Philippines extends Name { val value: String = "philippines" }
    case object CostaRica extends Name { val value: String = "costa rica" }
    case object Canada extends Name { val value: String = "canada" }
    case object Mc extends Name { val value: String = "mc" }
    case object CzechRepublic extends Name { val value: String = "czech republic" }
    case object Mt extends Name { val value: String = "mt" }
    case object Cn extends Name { val value: String = "cn" }
    case object Nc extends Name { val value: String = "nc" }
    case object Gl extends Name { val value: String = "gl" }
    case object Bf extends Name { val value: String = "bf" }
    case object IndianOceanTerritory extends Name { val value: String = "indian ocean territory" }
    case object Rwanda extends Name { val value: String = "rwanda" }
    case object Ug extends Name { val value: String = "ug" }
    case object Ms extends Name { val value: String = "ms" }
    case object Cm extends Name { val value: String = "cm" }
    case object Uruguay extends Name { val value: String = "uruguay" }
    case object ElSalvador extends Name { val value: String = "el salvador" }
    case object Chad extends Name { val value: String = "chad" }
    case object St extends Name { val value: String = "st" }
    case object Ca extends Name { val value: String = "ca" }
    case object Bd extends Name { val value: String = "bd" }
    case object Maldives extends Name { val value: String = "maldives" }
    case object Norway extends Name { val value: String = "norway" }
    case object Nf extends Name { val value: String = "nf" }
    case object Ru extends Name { val value: String = "ru" }
    case object Mu extends Name { val value: String = "mu" }
    case object Ma extends Name { val value: String = "ma" }
    case object VaticanCity extends Name { val value: String = "vatican city" }
    case object Np extends Name { val value: String = "np" }
    case object EquatorialGuinea extends Name { val value: String = "equatorial guinea" }
    case object Suriname extends Name { val value: String = "suriname" }
    case object Kenya extends Name { val value: String = "kenya" }
    case object Qatar extends Name { val value: String = "qatar" }
    case object Sj extends Name { val value: String = "sj" }
    case object Vn extends Name { val value: String = "vn" }
    case object Mq extends Name { val value: String = "mq" }
    case object Kuwait extends Name { val value: String = "kuwait" }
    case object Do extends Name { val value: String = "do" }
    case object SouthAfrica extends Name { val value: String = "south africa" }
    case object UsVirginIslands extends Name { val value: String = "us virgin islands" }
    case object Timorleste extends Name { val value: String = "timorleste" }
    case object SouthKorea extends Name { val value: String = "south korea" }
    case object Myanmar extends Name { val value: String = "myanmar" }
    case object Ye extends Name { val value: String = "ye" }
    case object Kiribati extends Name { val value: String = "kiribati" }
    case object Guyana extends Name { val value: String = "guyana" }
    case object Ee extends Name { val value: String = "ee" }
    case object Gp extends Name { val value: String = "gp" }
    case object Scotland extends Name { val value: String = "scotland" }
    case object Sl extends Name { val value: String = "sl" }
    case object Gb extends Name { val value: String = "gb" }
    case object Ai extends Name { val value: String = "ai" }
    case object PitcairnIslands extends Name { val value: String = "pitcairn islands" }
    case object Ie extends Name { val value: String = "ie" }
    case object Panama extends Name { val value: String = "panama" }
    case object UnitedArabEmirates extends Name { val value: String = "united arab emirates" }
    case object Ag extends Name { val value: String = "ag" }
    case object Sz extends Name { val value: String = "sz" }
    case object Ad extends Name { val value: String = "ad" }
    case object Sd extends Name { val value: String = "sd" }
    case object Er extends Name { val value: String = "er" }
    case object Somalia extends Name { val value: String = "somalia" }
    case object Uae extends Name { val value: String = "uae" }
    case object SaintPierre extends Name { val value: String = "saint pierre" }
    case object Th extends Name { val value: String = "th" }
    case object Guadeloupe extends Name { val value: String = "guadeloupe" }
    case object Br extends Name { val value: String = "br" }
    case object Tk extends Name { val value: String = "tk" }
    case object La extends Name { val value: String = "la" }
    case object Honduras extends Name { val value: String = "honduras" }
    case object Bolivia extends Name { val value: String = "bolivia" }
    case object Jamaica extends Name { val value: String = "jamaica" }
    case object Gr extends Name { val value: String = "gr" }
    case object CapeVerde extends Name { val value: String = "cape verde" }
    case object BurkinaFaso extends Name { val value: String = "burkina faso" }
    case object Iran extends Name { val value: String = "iran" }
    case object Tc extends Name { val value: String = "tc" }
    case object Ireland extends Name { val value: String = "ireland" }
    case object Italy extends Name { val value: String = "italy" }
    case object Eg extends Name { val value: String = "eg" }
    case object Hm extends Name { val value: String = "hm" }
    case object Libya extends Name { val value: String = "libya" }
    case object Bb extends Name { val value: String = "bb" }
    case object FrenchTerritories extends Name { val value: String = "french territories" }
    case object Kz extends Name { val value: String = "kz" }
    case object Madagascar extends Name { val value: String = "madagascar" }
    case object Kyrgyzstan extends Name { val value: String = "kyrgyzstan" }
    case object Gibraltar extends Name { val value: String = "gibraltar" }
    case object Mauritania extends Name { val value: String = "mauritania" }
    case object Brazil extends Name { val value: String = "brazil" }
    case object WallisAndFutuna extends Name { val value: String = "wallis and futuna" }
    case object Tn extends Name { val value: String = "tn" }
    case object Qa extends Name { val value: String = "qa" }
    case object SaintKittsAndNevis extends Name { val value: String = "saint kitts and nevis" }
    case object Chile extends Name { val value: String = "chile" }
    case object Iq extends Name { val value: String = "iq" }
    case object Montserrat extends Name { val value: String = "montserrat" }
    case object Kn extends Name { val value: String = "kn" }
    case object Slovakia extends Name { val value: String = "slovakia" }
    case object Lv extends Name { val value: String = "lv" }
    case object Bt extends Name { val value: String = "bt" }
    case object As extends Name { val value: String = "as" }
    case object Dj extends Name { val value: String = "dj" }
    case object Mw extends Name { val value: String = "mw" }
    case object Niger extends Name { val value: String = "niger" }
    case object Mx extends Name { val value: String = "mx" }
    case object Sb extends Name { val value: String = "sb" }
    case object Cl extends Name { val value: String = "cl" }
    case object Bn extends Name { val value: String = "bn" }
    case object In extends Name { val value: String = "in" }
    case object Ly extends Name { val value: String = "ly" }
    case object Cameroon extends Name { val value: String = "cameroon" }
    case object Liechtenstein extends Name { val value: String = "liechtenstein" }
    case object Ir extends Name { val value: String = "ir" }
    case object AmericanSamoa extends Name { val value: String = "american samoa" }
    case object CookIslands extends Name { val value: String = "cook islands" }
    case object Es extends Name { val value: String = "es" }
    case object Zimbabwe extends Name { val value: String = "zimbabwe" }
    case object SandwichIslands extends Name { val value: String = "sandwich islands" }
    case object Benin extends Name { val value: String = "benin" }
    case object Nicaragua extends Name { val value: String = "nicaragua" }
    case object Gn extends Name { val value: String = "gn" }
    case object Ua extends Name { val value: String = "ua" }
    case object Venezuela extends Name { val value: String = "venezuela" }
    case object Indonesia extends Name { val value: String = "indonesia" }
    case object An extends Name { val value: String = "an" }
    case object Tl extends Name { val value: String = "tl" }
    case object So extends Name { val value: String = "so" }
    case object Fo extends Name { val value: String = "fo" }
    case object HeardIsland extends Name { val value: String = "heard island" }
    case object Seychelles extends Name { val value: String = "seychelles" }
    case object Nepal extends Name { val value: String = "nepal" }
    case object NorfolkIsland extends Name { val value: String = "norfolk island" }
    case object Malaysia extends Name { val value: String = "malaysia" }
    case object Cv extends Name { val value: String = "cv" }
    case object Ae extends Name { val value: String = "ae" }
    case object Fiji extends Name { val value: String = "fiji" }
    case object Gambia extends Name { val value: String = "gambia" }
    case object Mk extends Name { val value: String = "mk" }
    case object Is extends Name { val value: String = "is" }
    case object Py extends Name { val value: String = "py" }
    case object Ky extends Name { val value: String = "ky" }
    case object Cuba extends Name { val value: String = "cuba" }
    case object Lc extends Name { val value: String = "lc" }
    case object Pn extends Name { val value: String = "pn" }
    case object Kh extends Name { val value: String = "kh" }
    case object Bj extends Name { val value: String = "bj" }
    case object Nz extends Name { val value: String = "nz" }
    case object Gm extends Name { val value: String = "gm" }
    case object Cu extends Name { val value: String = "cu" }
    case object Dominica extends Name { val value: String = "dominica" }
    case object Re extends Name { val value: String = "re" }
    case object JanMayen extends Name { val value: String = "jan mayen" }
    case object Singapore extends Name { val value: String = "singapore" }
    case object Denmark extends Name { val value: String = "denmark" }
    case object Barbados extends Name { val value: String = "barbados" }
    case object Jp extends Name { val value: String = "jp" }
    case object Peru extends Name { val value: String = "peru" }
    case object UsMinorIslands extends Name { val value: String = "us minor islands" }
    case object Mongolia extends Name { val value: String = "mongolia" }
    case object Israel extends Name { val value: String = "israel" }
    case object Za extends Name { val value: String = "za" }
    case object Am extends Name { val value: String = "am" }
    case object Uy extends Name { val value: String = "uy" }
    case object Ne extends Name { val value: String = "ne" }
    case object Malta extends Name { val value: String = "malta" }
    case object Morocco extends Name { val value: String = "morocco" }
    case object CaymanIslands extends Name { val value: String = "cayman islands" }
    case object Laos extends Name { val value: String = "laos" }
    case object Cyprus extends Name { val value: String = "cyprus" }
    case object Hu extends Name { val value: String = "hu" }
    case object CentralAfricanRepublic extends Name { val value: String = "central african republic" }
    case object De extends Name { val value: String = "de" }
    case object WesternSahara extends Name { val value: String = "western sahara" }
    case object SolomonIslands extends Name { val value: String = "solomon islands" }
    case object Lesotho extends Name { val value: String = "lesotho" }
    case object Pr extends Name { val value: String = "pr" }
    case object Botswana extends Name { val value: String = "botswana" }
    case object Oman extends Name { val value: String = "oman" }
    case object Sk extends Name { val value: String = "sk" }
    case object Gd extends Name { val value: String = "gd" }
    case object Eu extends Name { val value: String = "eu" }
    case object GbSct extends Name { val value: String = "gb sct" }
    case object Vi extends Name { val value: String = "vi" }
    case object Pm extends Name { val value: String = "pm" }
    case object Tuvalu extends Name { val value: String = "tuvalu" }
    case object Ar extends Name { val value: String = "ar" }
    case object Tokelau extends Name { val value: String = "tokelau" }
    case object Ht extends Name { val value: String = "ht" }
    case object FaroeIslands extends Name { val value: String = "faroe islands" }
    case object NewGuinea extends Name { val value: String = "new guinea" }
    case object GuineaBissau extends Name { val value: String = "guinea-bissau" }
    case object Bs extends Name { val value: String = "bs" }
    case object Cy extends Name { val value: String = "cy" }
    case object Georgia extends Name { val value: String = "georgia" }
    case object Sg extends Name { val value: String = "sg" }
    case object Nu extends Name { val value: String = "nu" }
    case object Comoros extends Name { val value: String = "comoros" }
    case object Mh extends Name { val value: String = "mh" }
    case object Serbia extends Name { val value: String = "serbia" }
    case object Pf extends Name { val value: String = "pf" }
    case object Aruba extends Name { val value: String = "aruba" }
    case object Samoa extends Name { val value: String = "samoa" }
    case object SaoTome extends Name { val value: String = "sao tome" }
    case object Bulgaria extends Name { val value: String = "bulgaria" }
    case object Kr extends Name { val value: String = "kr" }
    case object India extends Name { val value: String = "india" }
    case object Djibouti extends Name { val value: String = "djibouti" }
    case object Hr extends Name { val value: String = "hr" }
    case object Ghana extends Name { val value: String = "ghana" }
    case object Vu extends Name { val value: String = "vu" }
    case object FrenchPolynesia extends Name { val value: String = "french polynesia" }
    case object Gw extends Name { val value: String = "gw" }
    case object Burundi extends Name { val value: String = "burundi" }
    case object Kazakhstan extends Name { val value: String = "kazakhstan" }
    case object Ecuador extends Name { val value: String = "ecuador" }
    case object Tg extends Name { val value: String = "tg" }
    case object Bosnia extends Name { val value: String = "bosnia" }
    case object Russia extends Name { val value: String = "russia" }
    case object UnitedKingdom extends Name { val value: String = "united kingdom" }
    case object Gi extends Name { val value: String = "gi" }
    case object Nigeria extends Name { val value: String = "nigeria" }
    case object At extends Name { val value: String = "at" }
    case object Vietnam extends Name { val value: String = "vietnam" }
    case object Burma extends Name { val value: String = "burma" }
    case object Senegal extends Name { val value: String = "senegal" }
    case object Gt extends Name { val value: String = "gt" }
    case object Na extends Name { val value: String = "na" }
    case object Azerbaijan extends Name { val value: String = "azerbaijan" }
    case object Australia extends Name { val value: String = "australia" }
    case object Tr extends Name { val value: String = "tr" }
    case object Turkey extends Name { val value: String = "turkey" }
    case object Japan extends Name { val value: String = "japan" }
    case object Sn extends Name { val value: String = "sn" }
    case object Greenland extends Name { val value: String = "greenland" }
    case object Poland extends Name { val value: String = "poland" }
    case object CocosIslands extends Name { val value: String = "cocos islands" }
    case object Bahamas extends Name { val value: String = "bahamas" }
    case object Fr extends Name { val value: String = "fr" }
    case object Gabon extends Name { val value: String = "gabon" }
    case object It extends Name { val value: String = "it" }
    case object BouvetIsland extends Name { val value: String = "bouvet island" }
    case object My extends Name { val value: String = "my" }
    case object ChristmasIsland extends Name { val value: String = "christmas island" }
    case object Pakistan extends Name { val value: String = "pakistan" }
    case object Mr extends Name { val value: String = "mr" }
    case object Austria extends Name { val value: String = "austria" }
    case object Ec extends Name { val value: String = "ec" }
    case object Togo extends Name { val value: String = "togo" }
    case object EuropeanUnion extends Name { val value: String = "european union" }
    case object Mo extends Name { val value: String = "mo" }
    case object Wf extends Name { val value: String = "wf" }
    case object Lithuania extends Name { val value: String = "lithuania" }
    case object Taiwan extends Name { val value: String = "taiwan" }
    case object Croatia extends Name { val value: String = "croatia" }
    case object Cs extends Name { val value: String = "cs" }
    case object Jordan extends Name { val value: String = "jordan" }
    case object SaintVincent extends Name { val value: String = "saint vincent" }
    case object Guatemala extends Name { val value: String = "guatemala" }
    case object Hk extends Name { val value: String = "hk" }
    case object Eritrea extends Name { val value: String = "eritrea" }
    case object Tj extends Name { val value: String = "tj" }
    case object Ni extends Name { val value: String = "ni" }
    case object Lk extends Name { val value: String = "lk" }
    case object Armenia extends Name { val value: String = "armenia" }
    case object CoteDivoire extends Name { val value: String = "cote divoire" }
    case object Me extends Name { val value: String = "me" }
    case object Monaco extends Name { val value: String = "monaco" }
    case object Cr extends Name { val value: String = "cr" }
    case object Mm extends Name { val value: String = "mm" }
    case object Belize extends Name { val value: String = "belize" }
    case object Pl extends Name { val value: String = "pl" }
    case object Gh extends Name { val value: String = "gh" }
    case object Mg extends Name { val value: String = "mg" }
    case object Pa extends Name { val value: String = "pa" }
    case object Lu extends Name { val value: String = "lu" }
    case object Fk extends Name { val value: String = "fk" }
    case object Ro extends Name { val value: String = "ro" }
    case object Uk extends Name { val value: String = "uk" }
    case object Uzbekistan extends Name { val value: String = "uzbekistan" }
    case object America extends Name { val value: String = "america" }
    case object Afghanistan extends Name { val value: String = "afghanistan" }
    case object NetherlandsAntilles extends Name { val value: String = "netherlands antilles" }
    case object Li extends Name { val value: String = "li" }
    case object Yt extends Name { val value: String = "yt" }
    case object Mayotte extends Name { val value: String = "mayotte" }
    case object Turkmenistan extends Name { val value: String = "turkmenistan" }
    case object DominicanRepublic extends Name { val value: String = "dominican republic" }
    case object Lt extends Name { val value: String = "lt" }
    case object Cz extends Name { val value: String = "cz" }
    case object Switzerland extends Name { val value: String = "switzerland" }
    case object Bv extends Name { val value: String = "bv" }
    case object NorthernMarianaIslands extends Name { val value: String = "northern mariana islands" }
    case object Mp extends Name { val value: String = "mp" }
    case object Argentina extends Name { val value: String = "argentina" }
    case object No extends Name { val value: String = "no" }
    case object Ck extends Name { val value: String = "ck" }
    case object Macau extends Name { val value: String = "macau" }
    case object Belarus extends Name { val value: String = "belarus" }
    case object Bi extends Name { val value: String = "bi" }
    case object Ph extends Name { val value: String = "ph" }
    case object Ps extends Name { val value: String = "ps" }
    case object Us extends Name { val value: String = "us" }
    case object Zw extends Name { val value: String = "zw" }
    case object Luxembourg extends Name { val value: String = "luxembourg" }
    case object Tonga extends Name { val value: String = "tonga" }
    case object Mz extends Name { val value: String = "mz" }
    case object Co extends Name { val value: String = "co" }
    case object Fm extends Name { val value: String = "fm" }
    case object Germany extends Name { val value: String = "germany" }
    case object Bermuda extends Name { val value: String = "bermuda" }
    case object Mn extends Name { val value: String = "mn" }
    case object France extends Name { val value: String = "france" }
    case object Tm extends Name { val value: String = "tm" }
    case object Swaziland extends Name { val value: String = "swaziland" }
    case object PuertoRico extends Name { val value: String = "puerto rico" }
    case object Palau extends Name { val value: String = "palau" }
    case object Dm extends Name { val value: String = "dm" }
    case object Iceland extends Name { val value: String = "iceland" }
    case object Niue extends Name { val value: String = "niue" }
    case object Td extends Name { val value: String = "td" }
    case object Syria extends Name { val value: String = "syria" }
    case object Cc extends Name { val value: String = "cc" }
    case object Vanuatu extends Name { val value: String = "vanuatu" }
    case object Bh extends Name { val value: String = "bh" }
    case object Be extends Name { val value: String = "be" }
    case object Sv extends Name { val value: String = "sv" }
    case object Sm extends Name { val value: String = "sm" }
    case object Kw extends Name { val value: String = "kw" }
    case object Om extends Name { val value: String = "om" }
    case object Grenada extends Name { val value: String = "grenada" }
    case object Sh extends Name { val value: String = "sh" }
    case object Egypt extends Name { val value: String = "egypt" }
    case object Congo extends Name { val value: String = "congo" }
    case object Angola extends Name { val value: String = "angola" }
    case object Andorra extends Name { val value: String = "andorra" }
    case object SriLanka extends Name { val value: String = "sri lanka" }
    case object Ge extends Name { val value: String = "ge" }
    case object Algeria extends Name { val value: String = "algeria" }
    case object Bg extends Name { val value: String = "bg" }
    case object Wales extends Name { val value: String = "wales" }
    case object Gy extends Name { val value: String = "gy" }
    case object Se extends Name { val value: String = "se" }
    case object Sa extends Name { val value: String = "sa" }
    case object Uz extends Name { val value: String = "uz" }
    case object Guam extends Name { val value: String = "guam" }
    case object Montenegro extends Name { val value: String = "montenegro" }
    case object Belgium extends Name { val value: String = "belgium" }
    case object Micronesia extends Name { val value: String = "micronesia" }
    case object Tw extends Name { val value: String = "tw" }
    case object Antigua extends Name { val value: String = "antigua" }
    case object Pt extends Name { val value: String = "pt" }
    case object Guinea extends Name { val value: String = "guinea" }
    case object Paraguay extends Name { val value: String = "paraguay" }
    case object Greece extends Name { val value: String = "greece" }
    case object Bahrain extends Name { val value: String = "bahrain" }
    case object Af extends Name { val value: String = "af" }
    case object Cd extends Name { val value: String = "cd" }
    case object Kp extends Name { val value: String = "kp" }
    case object Au extends Name { val value: String = "au" }
    case object Gu extends Name { val value: String = "gu" }
    case object CaicosIslands extends Name { val value: String = "caicos islands" }
    case object Sy extends Name { val value: String = "sy" }
    case object Cg extends Name { val value: String = "cg" }
    case object Io extends Name { val value: String = "io" }
    case object Hungary extends Name { val value: String = "hungary" }
    case object Mauritius extends Name { val value: String = "mauritius" }
    case object Vg extends Name { val value: String = "vg" }
    case object Jo extends Name { val value: String = "jo" }
    case object Jm extends Name { val value: String = "jm" }
    case object Anguilla extends Name { val value: String = "anguilla" }
    case object Tz extends Name { val value: String = "tz" }
    case object Nr extends Name { val value: String = "nr" }
    case object Cambodia extends Name { val value: String = "cambodia" }
    case object Estonia extends Name { val value: String = "estonia" }
    case object Cf extends Name { val value: String = "cf" }
    case object Pg extends Name { val value: String = "pg" }
    case object Ls extends Name { val value: String = "ls" }
    case object Malawi extends Name { val value: String = "malawi" }
    case object Et extends Name { val value: String = "et" }
    case object Pk extends Name { val value: String = "pk" }
    case object Sc extends Name { val value: String = "sc" }
    case object Gf extends Name { val value: String = "gf" }
    case object Ki extends Name { val value: String = "ki" }
    case object Portugal extends Name { val value: String = "portugal" }
    case object Mozambique extends Name { val value: String = "mozambique" }
    case object Bw extends Name { val value: String = "bw" }
    case object Rw extends Name { val value: String = "rw" }
    case object Ba extends Name { val value: String = "ba" }
    case object Vc extends Name { val value: String = "vc" }
    case object Sudan extends Name { val value: String = "sudan" }
    case object Gs extends Name { val value: String = "gs" }
    case object Martinique extends Name { val value: String = "martinique" }
    case object Bz extends Name { val value: String = "bz" }
    case object China extends Name { val value: String = "china" }
    case object Cx extends Name { val value: String = "cx" }
    case object SaudiArabia extends Name { val value: String = "saudi arabia" }
    case object Hn extends Name { val value: String = "hn" }
    case object Pe extends Name { val value: String = "pe" }
    case object Ao extends Name { val value: String = "ao" }
    case object Ga extends Name { val value: String = "ga" }
    case object FrenchGuiana extends Name { val value: String = "french guiana" }
    case object SierraLeone extends Name { val value: String = "sierra leone" }
    case object Tt extends Name { val value: String = "tt" }
    case object Tanzania extends Name { val value: String = "tanzania" }
    case object MarshallIslands extends Name { val value: String = "marshall islands" }
    case object Albania extends Name { val value: String = "albania" }
    case object Gq extends Name { val value: String = "gq" }
    case object Svalbard extends Name { val value: String = "svalbard" }
    case object Al extends Name { val value: String = "al" }
    case object Mexico extends Name { val value: String = "mexico" }
    case object Ng extends Name { val value: String = "ng" }
    case object Ml extends Name { val value: String = "ml" }
    case object Mali extends Name { val value: String = "mali" }
    case object Yemen extends Name { val value: String = "yemen" }
    case object Ch extends Name { val value: String = "ch" }
    case object Eh extends Name { val value: String = "eh" }
    case object Um extends Name { val value: String = "um" }
    case object Lb extends Name { val value: String = "lb" }
    case object HongKong extends Name { val value: String = "hong kong" }
    case object Palestine extends Name { val value: String = "palestine" }
    case object CongoBrazzaville extends Name { val value: String = "congo brazzaville" }
    case object Km extends Name { val value: String = "km" }
    case object Trinidad extends Name { val value: String = "trinidad" }
    case object Haiti extends Name { val value: String = "haiti" }
    case object Bhutan extends Name { val value: String = "bhutan" }
    case object BritishVirginIslands extends Name { val value: String = "british virgin islands" }
    case object Ke extends Name { val value: String = "ke" }
    case object Sr extends Name { val value: String = "sr" }
    case object GbWls extends Name { val value: String = "gb wls" }
    case object Il extends Name { val value: String = "il" }
    case object NewZealand extends Name { val value: String = "new zealand" }
    case object NewCaledonia extends Name { val value: String = "new caledonia" }
    case object Ukraine extends Name { val value: String = "ukraine" }
    case object Md extends Name { val value: String = "md" }
    case object Id extends Name { val value: String = "id" }
    case object Nauru extends Name { val value: String = "nauru" }
    case object Macedonia extends Name { val value: String = "macedonia" }
    case object Tunisia extends Name { val value: String = "tunisia" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var name: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Flag")
  @js.native
  object FlagJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](FlagJS)
  
  /**
   * A flag is is used to represent a political state.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param key
   *        React key
   * @param name
   *        Flag name, can use the two digit country code, the full name, or a common alias.
   * @param style
   *        React element CSS style
   * @param additionalProps
   *        Optional parameter - if specified, this must be a js.Object containing additional props
   *        to pass to the underlying JS component. Each field of additionalProps will be added to the
   *        JS props object, if a field with the same name is not already present (from one of the other
   *        parameters of this function). This functions like `...additionalProps` at the beginning of the
   *        component in JS. Used for e.g. Downshift integration, where Downshift will provide properties
   *        in this format to be added to rendered components.
   *        Since this is untyped, use with care - e.g. make sure props are in the correct format for JS components
   */
  def apply(
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    name: js.UndefOr[Name] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (key.isDefined) {p.key = key}
    if (name.isDefined) {p.name = name.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)
  }

}
        