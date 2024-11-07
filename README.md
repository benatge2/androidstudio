Foroko Aplikazioa
Android Studio eta Jetpack Compose erabiliz garatutako foro-aplikazioa. Erabiltzaileek foro batetan parte hartzeko aukera ematen du, login eta logout funtzionalitateekin eta mezuei erantzuteko aukera eskainiz.

Funtzionalitate nagusiak
Login eta Logout: Erabiltzaileek aplikaziora sartu eta irten ahal dute izena emanda.
Foro batean parte hartzea: Erabiltzaileek foroan mezuak sortu eta beste erabiltzaileek idatzitako mezuei erantzun diezaiekete.
Mezuen gustukoak eta erantzunak: Mezu bakoitzari "Like" bat gehitu diezaiokezu eta, erantzunak idatzi, erantzun-kate hierarkiko bat sortuz.
Erabiltzaile-interfaze intuitiboa: Jetpack Compose erabiliz diseinatua, interfaze garbi eta erraz bat eskaintzen du.

Aplikazioa nola erabili
Sartzea: Aplikazioa irekitzean, erabiltzaileek beren izena idatzi eta foroan sartu daitezke "Sartu" botoia erabiliz.
Foroan parte hartzea: Behin foroan, erabiltzaileek mezu berriak idatzi eta beste erabiltzaileen mezuei erantzun diezaiekete.
Mezu bati "Like" ematea edo erantzutea: Mezu batean klik eginda, "Like" bat gehi daiteke edo erantzun bat idatzi.
Irteera: Goiko eskuineko aldeko "Irten" botoia erabiliz, erabiltzaileek aplikaziotik irten daitezke.

Diseinu erabaki garrantzitsuenak
Jetpack Compose: Jetpack Compose erabiltzea erabaki dugu UIa garbitasuna eta koderen mantentagarritasuna lortzeko.
Room datu-biltegiratzea: Room liburutegia erabiltzea aukeratu dugu datuak aplikaziotik ateratzean ere gordeak izan daitezen.
Komunikazio-arintzea eta erabiltzaile-esperientzia: Aplikazioa erabiltzaileari arintasuna eta diseinu garbia eskainiz sortu dugu, interfaze sinple baina eraginkorra eskainiz.

Estruktura eta funtzionamendua
Aplikazioak bi pantaila nagusi ditu:

LoginScreen: Erabiltzailea foroan sartzeko erabiltzen da; izena sartu eta "Sartu" botoia sakatuz.
ForumScreen: Foroaren edukia ikusi eta parte hartzeko aukera ematen du, bertan mezu berriak idatzi, gustukoak gehitu eta erantzunak idatz daitezke.
