package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Connection.ConexionBD;
import Modelo.Equipo;
import Modelo.Fichaje;
import Modelo.Jugador;
import PatronDAO.EquipoDAO;
import PatronDAO.EquipoDAOImpl;
import PatronDAO.FichajeDAO;
import PatronDAO.FichajeDAOImpl;
import PatronDAO.JugadorDAO;
import PatronDAO.JugadorDAOImpl;

/**
 * Esta clase se encarga de instanciar los objetos y persistirlos en la base de
 * datos
 * 
 * @author Tamara Garcia Marcos
 */
public class Main {

	public static void main(String[] args) {

		EquipoDAO equipoDAO = new EquipoDAOImpl();
		JugadorDAO jugadorDAO = new JugadorDAOImpl();
		FichajeDAO fichajeDAO = new FichajeDAOImpl();
		try {

			// Astralis
			Jugador finn = new Jugador("'Finn' Finn Wiestal", "Suecia", LocalDate.of(03, 6, 1999), "Top");
			Jugador _113 = new Jugador("'113'Dogukan Balch", "Turquía", LocalDate.of(12, 8, 2004), "Jungla");
			Jugador dajor = new Jugador("'Dajor'Oliver Rippa", "Alemania", LocalDate.of(18, 4, 2003), "Mid");
			Jugador kobbe = new Jugador("'Kobbe'Kasper Kobbertup", "Dinamarca", LocalDate.of(21, 9, 1996), "Bot");
			Jugador jeonghoon = new Jugador("'JeongHoon'Lee Jeong-Hoon", "Korea del Sur", LocalDate.of(22, 2, 2000),
					"Support");

			Equipo astralis = new Equipo("Astralis");
			equipoDAO.insert(astralis);
			jugadorDAO.insert(finn);
			jugadorDAO.insert(_113);
			jugadorDAO.insert(dajor);
			jugadorDAO.insert(kobbe);
			jugadorDAO.insert(jeonghoon);

			// Excel
			Jugador odoamne = new Jugador("'Odoamne' Andrei Pascu", "Rumania", LocalDate.of(18, 1, 1995), "Top");
			Jugador xerxe = new Jugador("'Xerxe' Andrei Dragomir", "Rumania", LocalDate.of(05, 11, 1999), "Jungla");
			Jugador vetheo = new Jugador("'Vetheo' Vincent Berrié", "Francia", LocalDate.of(26, 7, 2002), "Mid");
			Jugador patrick = new Jugador("'Patrick' Patrick Jirú", "Republica Checa", LocalDate.of(04, 4, 2000),
					"Bot");
			Jugador targamas = new Jugador("'Targamas' Rapphael Crabbé", "Bélgica", LocalDate.of(30, 6, 2000),
					"Support");

			Equipo excel = new Equipo("Excel");
			equipoDAO.insert(excel);
			jugadorDAO.insert(odoamne);
			jugadorDAO.insert(xerxe);
			jugadorDAO.insert(patrick);
			jugadorDAO.insert(vetheo);
			jugadorDAO.insert(targamas);

			// Fnatic
			Jugador wunder = new Jugador("'Wunder' Martin Nordahl", "Dinamarca", LocalDate.of(9, 11, 1998), "Top");
			Jugador razork = new Jugador("'Razork' Ivan Martin", "España", LocalDate.of(07, 10, 2000), "Jungla");
			Jugador humanoid = new Jugador("'Humanoid' Marek Brazda", "Republica Checa", LocalDate.of(14, 3, 2000),
					"Mid");
			Jugador rekkles = new Jugador("'Rekkles' Carl Martin", "Suecia", LocalDate.of(20, 9, 1996), "Bot");
			Jugador rhuckz = new Jugador("'Rhuckz' Rubén Barbosa", "Protugal", LocalDate.of(28, 8, 1996), "Support");

			Equipo fnatic = new Equipo("Fnatic");
			jugadorDAO.insert(wunder);
			jugadorDAO.insert(razork);
			jugadorDAO.insert(humanoid);
			jugadorDAO.insert(rekkles);
			jugadorDAO.insert(rhuckz);

			// G2 Sports
			Jugador brokenblade = new Jugador("'BrokenBlade' Sergen Çelic", "Alemania", LocalDate.of(19, 1, 2000),
					"Top");
			Jugador yike = new Jugador("'Yike' Martin Sundelin", "Suecia", LocalDate.of(11, 11, 2000), "Jungla");
			Jugador caps = new Jugador("'Caps' Rasmus Borregard", "Dinamarca", LocalDate.of(17, 11, 1999), "Mid");
			Jugador manssama = new Jugador("'MansSama' Steven Liv", "Francia", LocalDate.of(2, 9, 1999), "Bot");
			Jugador mikyx = new Jugador("'Mikyx' Mihael Mehle", "Eslovenia", LocalDate.of(2, 11, 1992), "Support");

			Equipo g2 = new Equipo("G2 Sports");
			equipoDAO.insert(g2);
			jugadorDAO.insert(brokenblade);
			jugadorDAO.insert(yike);
			jugadorDAO.insert(caps);
			jugadorDAO.insert(manssama);
			jugadorDAO.insert(mikyx);

			// KOI
			Jugador szygenda = new Jugador("'LocalDate.of(28,7,1991)' Mathias Jensen", "Dinamarca",
					LocalDate.of(14, 4, 2001), "Top");
			Jugador marlang = new Jugador("'Marlang' Kim Geun-Sendg", "Korea del Sur", LocalDate.of(9, 2, 2000),
					"Jungla");
			Jugador larssen = new Jugador("'Larssen' Emil Larsson", "Suecia", LocalDate.of(30, 3, 2000), "Mid");
			Jugador comp = new Jugador("'Comp' Markos Stamkopoulos", "Grecia", LocalDate.of(20, 12, 2001), "Bot");
			Jugador trimby = new Jugador("'Trimby' Adrian Tribu", "Polonia", LocalDate.of(20, 10, 2000), "Support");

			Equipo koi = new Equipo("KOI");
			equipoDAO.insert(koi);
			jugadorDAO.insert(szygenda);
			jugadorDAO.insert(marlang);
			jugadorDAO.insert(larssen);
			jugadorDAO.insert(comp);
			jugadorDAO.insert(trimby);

			// Mad Lions
			Jugador chasy = new Jugador("'Chasy' Kim Dong-Hyeon", "Korea del Sur", LocalDate.of(20, 4, 2001), "Top");
			Jugador elyoya = new Jugador("'ElYoya' Javier Prades", "España", LocalDate.of(13, 3, 2000), "Jungla");
			Jugador nisqy = new Jugador("'Nisqy' Yasin Dincer", "Bélgica", LocalDate.of(28, 7, 1998), "Mid");
			Jugador carzzy = new Jugador("'Carzzy' Matias Orsag", "República Checa", LocalDate.of(31, 1, 2001), "Bot");
			Jugador hylissang = new Jugador("'Hylissang' Zdravets", "Bulgaria", LocalDate.of(30, 4, 1995), "Support");

			Equipo madlions = new Equipo("Mad Lions");
			equipoDAO.insert(madlions);
			jugadorDAO.insert(chasy);
			jugadorDAO.insert(elyoya);
			jugadorDAO.insert(nisqy);
			jugadorDAO.insert(carzzy);
			jugadorDAO.insert(hylissang);

			// SK Gaming
			Jugador irrelevant = new Jugador("'Irrelevant' Joel Miro", "Alemania", LocalDate.of(22, 10, 2002), "Top");
			Jugador markoon = new Jugador("'Markoon' Mark Van Woensei", "Paises Bajos", LocalDate.of(28, 6, 2002),
					"Jungla");
			Jugador sertuss = new Jugador("'Sertuss' Daniel Gamani", "Alemania", LocalDate.of(23, 12, 2001), "Mid");
			Jugador exakick = new Jugador("'Exakick' Thomas Foucou", "Francia", LocalDate.of(28, 9, 2003), "Bot");
			Jugador doss = new Jugador("'Doss' Mads Schwartz", "Dinamarca", LocalDate.of(19, 3, 1999), "Support");

			Equipo sk = new Equipo("SK Gaming");
			equipoDAO.insert(sk);
			jugadorDAO.insert(irrelevant);
			jugadorDAO.insert(markoon);
			jugadorDAO.insert(sertuss);
			jugadorDAO.insert(exakick);
			jugadorDAO.insert(doss);

			// Team BDS
			Jugador adam = new Jugador("'Adam' Adam Maanane", "Francia", LocalDate.of(19, 3, 1999), "Top");
			Jugador sheo = new Jugador("Sheo' Theo Borile", "Francia", LocalDate.of(19, 3, 1999), "Jungla");
			Jugador nuc = new Jugador("'Nuc' Illias Bizriken", "Francia", LocalDate.of(19, 3, 1999), "Mid");
			Jugador crownie = new Jugador("'Crownie' Jus Marusic", "Eslovenia", LocalDate.of(19, 3, 1999), "Bot");
			Jugador labroy = new Jugador("'Labroy' Labros Patoutsakis", "Grecia", LocalDate.of(19, 3, 1999), "Support");

			Equipo bds = new Equipo("Team BDS");
			equipoDAO.insert(bds);
			jugadorDAO.insert(adam);
			jugadorDAO.insert(sheo);
			jugadorDAO.insert(nuc);
			jugadorDAO.insert(crownie);
			jugadorDAO.insert(labroy);

			// Team Heretics
			Jugador evi = new Jugador("'Evi' Shunsuke Murase", "Japon", LocalDate.of(15, 11, 1995), "Top");
			Jugador jankos = new Jugador("'Jankos' Marcin Jankowski", "Polonia", LocalDate.of(23, 7, 1995), "Jungla");
			Jugador ruby = new Jugador("'Ruby' Lee Sol-min", "Korea del Sur", LocalDate.of(11, 8, 1998), "Mid");
			Jugador jackspektra = new Jugador("'JackSpektra' Jacob Gulivan", "Noruega", LocalDate.of(5, 12, 2000),
					"Bot");
			Jugador mersa = new Jugador("'Mersa' Mertai Sari", "Grecia", LocalDate.of(22, 8, 2002), "Support");

			Equipo heretics = new Equipo("Team Heretics");
			equipoDAO.insert(heretics);
			jugadorDAO.insert(evi);
			jugadorDAO.insert(jankos);
			jugadorDAO.insert(ruby);
			jugadorDAO.insert(jackspektra);
			jugadorDAO.insert(mersa);

			// Team Vitality
			Jugador photon = new Jugador("'Photon' Kyeong Gyun-Tae", "Korea del Sur", LocalDate.of(30, 11, 2001),
					"Top");
			Jugador bo = new Jugador("'Bo' Zhou Yang-Bo", "China", LocalDate.of(2, 3, 2002), "Jungla");
			Jugador perkz = new Jugador("'Perkz' Luka Perkovic", "Croacia", LocalDate.of(30, 9, 1998), "Mid");
			Jugador neon = new Jugador("'Neon' Matús Jakubcik", "Eslovaquia", LocalDate.of(24, 4, 1999), "Bot");
			Jugador kaiser = new Jugador("'Kaiser' Norman Kaiser", "Alemania", LocalDate.of(19, 11, 1998), "Support");

			Equipo vitality = new Equipo("Team Vitality");
			equipoDAO.insert(vitality);
			jugadorDAO.insert(photon);
			jugadorDAO.insert(bo);
			jugadorDAO.insert(perkz);
			jugadorDAO.insert(neon);
			jugadorDAO.insert(kaiser);

			// Fichajes de los jugadores. Cambios de equipo
			Fichaje fichaje1 = new Fichaje(LocalDate.now(), finn, astralis, koi);
			Fichaje fichaje2 = new Fichaje(LocalDate.now(), elyoya, madlions, sk);

			fichajeDAO.insert(fichaje1);
			fichajeDAO.insert(fichaje2);

			// Fichajes nuevos
			Fichaje fichaje4 = new Fichaje(LocalDate.now(), mersa);
			Fichaje fichaje5 = new Fichaje(LocalDate.now(), kaiser);
			fichajeDAO.insert(fichaje4);
			fichajeDAO.insert(fichaje5);

			System.out.println(
					"****************************************************************************************");

			// Mostrar los quipos
			List<Equipo> equipos = equipoDAO.getAll();
			System.out.println("Equipos:");
			for (Equipo equipo : equipos) {
				System.out.println(equipo.getNombre());
			}

			// Mostrar los jugadores
			List<Jugador> jugadores = jugadorDAO.getAll();
			System.out.println("\nJugadores:");
			for (Jugador jugador : jugadores) {
				System.out.println(
						jugador.getNombre() + " - " + jugador.getNacionalidad() + " - " + jugador.getFechaNacimiento());
			}

			// Mostrar los fichajes
			List<Fichaje> fichajes = fichajeDAO.getAll();
			System.out.println("\nFichajes:");
			for (Fichaje fichaje : fichajes) {
				System.out.println(fichaje.getFecha() + " - " + fichaje.getJugador().getNombre());
			}

			// Crear archivo de historial de fichajes
			archivoFichajes(fichajes);

			// Crear archivo de plantillas de equipos
			archivoPlantillas(equipos, jugadorDAO);

			// Crear archivo binario con el historial de fichajes
			guardarHistorialFichajes(fichajes);
			// Imprimir el historial de fichajes en pantalla
			mostrarFichajes();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

	private static void archivoFichajes(List<Fichaje> fichajes) throws IOException {
		try (FileWriter writer = new FileWriter("fichajes/historial_fichajes.txt")) {
			for (Fichaje fichaje : fichajes) {
				String linea = fichaje.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", "
						+ fichaje.getJugador().getNombre() + "\n";
				writer.write(linea);
			}
		}
	}

	private static void archivoPlantillas(List<Equipo> equipos, JugadorDAO jugadorDAO)
			throws IOException, SQLException {
		try (FileWriter writer = new FileWriter("fichajes/plantillas_equipos.txt")) {
			for (Equipo equipo : equipos) {
				writer.write("---- " + equipo.getNombre() + " ----\n");
				List<Jugador> jugadoresEquipo = jugadorDAO.obtenerJugadoresPorEquipo(equipo.getNombre());
				for (Jugador jugador : jugadoresEquipo) {
					String linea = jugador.getNombre() + ", " + jugador.getNacionalidad() + ", "
							+ jugador.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n";
					writer.write(linea);
				}
			}
		}
	}

	private static void guardarHistorialFichajes(List<Fichaje> fichajes) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("fichajes/historial_fichajes.bin"))) {
			for (Fichaje fichaje : fichajes) {
				out.writeObject(fichaje);
			}
		}
	}

	private static void mostrarFichajes() throws IOException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("fichajes/historial_fichajes.bin"))) {
			System.out.println("\nHistorial de fichajes:");
			while (true) {
				try {
					Fichaje fichaje = (Fichaje) in.readObject();
					System.out.println(fichaje.getFecha() + " - " + fichaje.getJugador().getNombre());
				} catch (ClassNotFoundException e) {
					System.err.println("Error: Clase no encontrada durante la deserialización.");
				} catch (IOException e) {
					// EOFException al final del archivo
					break;
				}
			}
		}
	}

	private static void dropAndCreateTables() throws SQLException {
		try (Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement()) {
			// Eliminar tabla si existe
			stmt.executeUpdate("DROP TABLE IF EXISTS fichajes");
			stmt.executeUpdate("DROP TABLE IF EXISTS jugadores");
			stmt.executeUpdate("DROP TABLE IF EXISTS equipos");

			// Crear nuevas tablas
			stmt.executeUpdate(
					"CREATE TABLE equipos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), tiene_plantilla BOOLEAN DEFAULT false)");
			stmt.executeUpdate(
					"CREATE TABLE jugadores (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), nacionalidad VARCHAR(25), fecha_nacimiento DATE, equipo_id INT, FOREIGN KEY (equipo_id) REFERENCES equipos(id))");
			stmt.executeUpdate(
					"CREATE TABLE fichajes (id INT AUTO_INCREMENT PRIMARY KEY, fecha DATE, nombre_jugador VARCHAR(25))");
		}
	}

}
