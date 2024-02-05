package Main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Clases.CompeticionDAO;
import Clases.EquipoDAO;
import Clases.JugadorDAO;
import Modelo.Competicion;
/**
 * Esta clase se encarga de instanciar los objetos y persistirlos en la base de datos
 * 
 * @author Tamara Garcia Marcos
 */
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Patrocinador;

public class Main {

	public static void main(String[] args) {

		//Patrocinadores
		Patrocinador audi = new Patrocinador("Audi");
		Patrocinador logitech = new Patrocinador("Logitech G");
		Patrocinador justeat = new Patrocinador("Just Eat");
		Patrocinador jdsports = new Patrocinador("JD Sports");
		Patrocinador monster = new Patrocinador("Monster Energy");
		Patrocinador asos = new Patrocinador("Asos");
		Patrocinador adidas = new Patrocinador("Adidas");
		Patrocinador nike = new Patrocinador("Nike");
		Patrocinador hummel = new Patrocinador("Hummel");
		Patrocinador cupra = new Patrocinador("Cupra");
		Patrocinador overactive = new Patrocinador("Overactive Media");
		Patrocinador mercedes = new Patrocinador("Mercedes-Benz");
		Patrocinador nh = new Patrocinador("NH Hotel");
		Patrocinador gfuel = new Patrocinador("GFuel");
		Patrocinador ozone = new Patrocinador("Ozone Gaming Gear");
		Patrocinador garnier = new Patrocinador("Garnier Fructis");
		
		//Astralis
		Jugador finn = new Jugador("Finn","Finn Wiestal","Suecia", "03-06-1999" ,"Top");
		Jugador _113 = new Jugador("113","Dogukan Balch","Turquía", "12-08-2004" ,"Jungla");
		Jugador dajor = new Jugador("Dajor","Oliver Rippa","Alemania", "18-04-2003" ,"Mid");
		Jugador kobbe = new Jugador("Kobbe","Kasper Kobbertup","Dinamarca", "21-09-1996" ,"Bot");
		Jugador jeonghoon = new Jugador("JeongHoon","Lee Jeong-Hoon","Korea del Sur", "22-02-200" ,"Support");
		Jugador aod = new Jugador("AoD","Alin-Ciprian Valtat","Romania", "26-01-1993" ,"Coach");
		
		Equipo astralis = new Equipo("Astralis");
		astralis.agregarJugador(finn);
		astralis.agregarJugador(_113);
		astralis.agregarJugador(dajor);
		astralis.agregarJugador(kobbe);
		astralis.agregarJugador(jeonghoon);
		astralis.agregarJugador(aod);
		
		astralis.agregarPatrocinador(audi);
		astralis.agregarPatrocinador(logitech);
		
		//Excel
		Jugador odoamne = new Jugador("Odoamne","Andrei Pascu","Rumania", "18-01-1995" ,"Top");
		Jugador xerxe = new Jugador("Xerxe","Andrei Dragomir","Rumania", "05-11-1999" ,"Jungla");
		Jugador vetheo = new Jugador("Vetheo","Vincent Berrié","Francia", "26-07-2002" ,"Mid");
		Jugador patrick = new Jugador("Patrick","Patrick Jirú","Republica Checa", "04-04-2000" ,"Bot");
		Jugador targamas = new Jugador("Targamas","Rapphael Crabbé","Bélgica", "30-06-2000" ,"Support");
		Jugador youngbuck = new Jugador("YoungBuck","Joey Steltenpool","Paises Bajos", "28-07-1991" ,"Cocah");
		
		Equipo excel = new Equipo ("Excel");
		excel.agregarJugador(odoamne);
		excel.agregarJugador(xerxe);
		excel.agregarJugador(patrick);
		excel.agregarJugador(vetheo);
		excel.agregarJugador(targamas);
		excel.agregarJugador(youngbuck);
		
		excel.agregarPatrocinador(justeat);
		excel.agregarPatrocinador(jdsports);
		
		//Fnatic
		Jugador wunder = new Jugador("Wunder","Martin Nordahl","Dinamarca", "09-11-1998" ,"Top");
		Jugador razork = new Jugador("Razork","Ivan Martin","España", "07-10-2000" ,"Jungla");
		Jugador humanoid = new Jugador("Humanoid","Marek Brazda","Republica Checa", "14-03-2000" ,"Mid");
		Jugador rekkles = new Jugador("Rekkles","Carl Martin","Suecia", "20-09-1996" ,"Bot");
		Jugador rhuckz = new Jugador("Rhuckz","Rubén Barbosa","Protugal", "28-08-1996" ,"Support");
		Jugador crusher = new Jugador("Crusher","Gonçalo Pinto","Portugal", "24-08-1992" ,"Cocah");
		
		Equipo fnatic = new Equipo ("Fnatic");
		fnatic.agregarJugador(wunder);
		fnatic.agregarJugador(razork);
		fnatic.agregarJugador(humanoid);
		fnatic.agregarJugador(rekkles);
		fnatic.agregarJugador(rhuckz);
		fnatic.agregarJugador(crusher);
		
		fnatic.agregarPatrocinador(monster);
		fnatic.agregarPatrocinador(asos);
		
		//G2 Sports
		Jugador brokenblade = new Jugador("BrokenBlade","Sergen Çelic","Alemania", "19-01-2000" ,"Top");
		Jugador yike = new Jugador("Yike","Martin Sundelin","Suecia", "11-11-2000" ,"Jungla");
		Jugador caps = new Jugador("Caps","Rasmus Borregard","Dinamarca", "17-11-1999" ,"Mid");
		Jugador manssama = new Jugador("MansSama","Steven Liv","Francia", "02-09-1999" ,"Bot");
		Jugador mikyx = new Jugador("Mikyx","Mihael Mehle","Eslovenia", "02-11-1992" ,"Support");
		Jugador dylanfalco = new Jugador("DylanFalco","Dylan Falco","Canadá", "05-03-1990" ,"Cocah");
		
		Equipo g2 = new Equipo ("G2 Sports");
		g2.agregarJugador(brokenblade);
		g2.agregarJugador(yike);
		g2.agregarJugador(caps);
		g2.agregarJugador(manssama);
		g2.agregarJugador(mikyx);
		g2.agregarJugador(dylanfalco);
		
		g2.agregarPatrocinador(logitech);
		g2.agregarPatrocinador(adidas);
		
		//KOI
		Jugador szygenda = new Jugador("Szygenda","Mathias Jensen","Dinamarca", "14-04-2001" ,"Top");
		Jugador marlang = new Jugador("Marlang","Kim Geun-Sendg","Korea del Sur", "09-02-2000" ,"Jungla");
		Jugador larssen = new Jugador("Larssen","Emil Larsson","Suecia", "30-03-2000" ,"Mid");
		Jugador comp = new Jugador("Comp","Markos Stamkopoulos","Grecia", "20-12-2001" ,"Bot");
		Jugador trimby = new Jugador("Trimby","Adrian Tribu","Polonia", "20-10-2000" ,"Support");
		Jugador arvindir = new Jugador("Arvindir","Danusch Fischer","Alemania", "15-06-1995" ,"Cocah");
		
		Equipo koi = new Equipo ("KOI");
		koi.agregarJugador(szygenda);
		koi.agregarJugador(marlang);
		koi.agregarJugador(larssen);
		koi.agregarJugador(comp);
		koi.agregarJugador(trimby);
		koi.agregarJugador(arvindir);
		
		koi.agregarPatrocinador(nike);
		koi.agregarPatrocinador(cupra);
		
		//Mad Lions
		Jugador chasy = new Jugador("Chasy","Kim Dong-Hyeon","Korea del Sur", "20-04-2001" ,"Top");
		Jugador elyoya = new Jugador("ElYoya","Javier Prades","España", "13-03-2000" ,"Jungla");
		Jugador nisqy = new Jugador("Nisqy","Yasin Dincer","Bélgica", "28-07-1998" ,"Mid");
		Jugador carzzy = new Jugador("Carzzy","Matias Orsag","República Checa", "31-01-2001" ,"Bot");
		Jugador hylissang = new Jugador("Hylissang","Zdravets","Bulgaria", "30-04-1995" ,"Support");
		Jugador mac = new Jugador("Mac","James MacCormak","Reino Unido", "13-02-1994" ,"Cocah");
		
		Equipo madlions = new Equipo ("Mad Lions");
		madlions.agregarJugador(chasy);
		madlions.agregarJugador(elyoya);
		madlions.agregarJugador(nisqy);
		madlions.agregarJugador(carzzy);
		madlions.agregarJugador(hylissang);
		madlions.agregarJugador(mac);
		
		madlions.agregarPatrocinador(overactive);
		
		
		//SK Gaming
		Jugador irrelevant = new Jugador("Irrelevant","Joel Miro","Alemania", "22-10-2002" ,"Top");
		Jugador markoon = new Jugador("Markoon","Mark Van Woensei","Paises Bajos", "28-06-2002" ,"Jungla");
		Jugador sertuss = new Jugador("Sertuss","Daniel Gamani","Alemania", "23-12-2001" ,"Mid");
		Jugador exakick = new Jugador("Exakick","Thomas Foucou","Francia", "28-09-2003" ,"Bot");
		Jugador doss = new Jugador("Doss","Mads Schwartz","Dinamarca", "19-03-1999" ,"Support");
		Jugador own3r = new Jugador("Own3r","David Rodriguez","España", "21-05-1994" ,"Cocah");
		
		Equipo sk = new Equipo ("SK Gaming");
		sk.agregarJugador(irrelevant);
		sk.agregarJugador(markoon);
		sk.agregarJugador(sertuss);
		sk.agregarJugador(exakick);
		sk.agregarJugador(doss);
		sk.agregarJugador(own3r);
		
		sk.agregarPatrocinador(mercedes);
		sk.agregarPatrocinador(nh);
		
		//Team BDS
		Jugador adam = new Jugador("Adam","Adam Maanane","Francia", "30-12-2001" ,"Top");
		Jugador sheo = new Jugador("Sheo","Theo Borile","Francia", "05-07-2001" ,"Jungla");
		Jugador nuc = new Jugador("Nuc","Illias Bizriken","Francia", "17-10-2002" ,"Mid");
		Jugador crownie = new Jugador("Crownie","Jus Marusic","Eslovenia", "17-04-1998" ,"Bot");
		Jugador labroy = new Jugador("Labroy","Labros Patoutsakis","Grecia", "12-02-2002" ,"Support");
		Jugador gotoone = new Jugador("GoToOne","Adrien Picard","Francia", "08-06-1994" ,"Cocah");
		
		Equipo bds = new Equipo ("Team BDS");
		bds.agregarJugador(adam);
		bds.agregarJugador(sheo);
		bds.agregarJugador(nuc);
		bds.agregarJugador(crownie);
		bds.agregarJugador(labroy);
		bds.agregarJugador(gotoone);
		
		//Team Heretics 
		Jugador evi = new Jugador("Evi","Shunsuke Murase","Japon", "15-11-1995" ,"Top");
		Jugador jankos = new Jugador("Jankos","Marcin Jankowski","Polonia", "23-07-1995" ,"Jungla");
		Jugador ruby = new Jugador("Ruby","Lee Sol-min","Korea del Sur", "11-08-1998" ,"Mid");
		Jugador jackspektra = new Jugador("JackSpektra","Jacob Gulivan","Noruega", "05-12-2000" ,"Bot");
		Jugador mersa = new Jugador("Mersa","Mertai Sari","Grecia", "22-08-2002" ,"Support");
		Jugador peterdun = new Jugador("Peterdun","Peter Dun","Reino Unido", "24-07-1987" ,"Cocah");
		
		Equipo heretics = new Equipo ("Team Heretics");
		heretics.agregarJugador(evi);
		heretics.agregarJugador(jankos);
		heretics.agregarJugador(ruby);
		heretics.agregarJugador(jackspektra);
		heretics.agregarJugador(mersa);
		heretics.agregarJugador(peterdun);
		
		heretics.agregarPatrocinador(ozone);
		heretics.agregarPatrocinador(gfuel);
		
		//Team Vitality
		Jugador photon = new Jugador("Photon","Kyeong Gyun-Tae","Korea del Sur", "30-11-2001" ,"Top");
		Jugador bo = new Jugador("Bo","Zhou Yang-Bo","China", "02-03-2002" ,"Jungla");
		Jugador perkz = new Jugador("Perkz","Luka Perkovic","Croacia", "30-09-1998" ,"Mid");
		Jugador neon = new Jugador("Neon","Matús Jakubcik","Eslovaquia", "24-04-1999" ,"Bot");
		Jugador kaiser = new Jugador("Kaiser","Norman Kaiser","Alemania", "19-11-1998" ,"Support");
		Jugador hjarnan = new Jugador("Hjarnan","Petter Freyschuss","Suecia", "18-11-1993" ,"Cocah");
		
		Equipo vitality = new Equipo ("Team Vitality");
		vitality.agregarJugador(photon);
		vitality.agregarJugador(bo);
		vitality.agregarJugador(perkz);
		vitality.agregarJugador(neon);
		vitality.agregarJugador(kaiser);
		vitality.agregarJugador(hjarnan);
		
		vitality.agregarPatrocinador(garnier);
		vitality.agregarPatrocinador(hummel);

		//Competicion
		Competicion lec = new Competicion("LEC League of Legends", "2023");
		lec.agregarEquipo(astralis);
		lec.agregarEquipo(excel);
		lec.agregarEquipo(fnatic);
		lec.agregarEquipo(madlions);
		lec.agregarEquipo(koi);
		lec.agregarEquipo(g2);
		lec.agregarEquipo(bds);
		lec.agregarEquipo(sk);
		lec.agregarEquipo(heretics);
		lec.agregarEquipo(vitality);

	}
	
	


}
