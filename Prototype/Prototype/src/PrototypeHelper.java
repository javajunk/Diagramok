import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;
import java.util.Map.Entry;

public class PrototypeHelper {

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	static ArrayList<Double> randoms = new ArrayList<Double>();
	static int randIndex = 0;
	static Hashtable<String, Integer> controlKeyNames = new Hashtable<String, Integer>();

	static Game game;

	public static void Init(Game g) {
		game = g;

		controlKeyNames.put("W", KeyEvent.VK_W);
		controlKeyNames.put("A", KeyEvent.VK_A);
		controlKeyNames.put("S", KeyEvent.VK_S);
		controlKeyNames.put("D", KeyEvent.VK_D);
		controlKeyNames.put("Q", KeyEvent.VK_Q);
		controlKeyNames.put("E", KeyEvent.VK_E);

		controlKeyNames.put("P", KeyEvent.VK_P);
		controlKeyNames.put("L", KeyEvent.VK_L);
		controlKeyNames.put("É", 39);
		controlKeyNames.put("Á", 40);
		controlKeyNames.put("O", KeyEvent.VK_O);
		controlKeyNames.put("Ö", 26);
	}

	private static void StupidUserMessage() {
		System.out
				.println("First read this document: 7. Prototípus koncepciója");
	}

	private static String[] ReadCommandWithArguments() {
		String[] command = new String[2];

		try {
			String tmp = (br.readLine().split("//"))[0];
			int commandEnd = tmp.indexOf(' ');
			if (commandEnd != -1) {
				command[0] = tmp.substring(0, commandEnd);
				command[1] = tmp.substring(commandEnd + 1, tmp.length()).trim();
			} else {
				command[0] = tmp;
				command[1] = new String();
			}

			command[0] = command[0].toLowerCase();

		} catch (IOException e) {
			System.out.print("Something went wrong. :(");
		}

		return command;
	}

	private static void Update(String[] commAndArgs) {
		String keyNames[] = commAndArgs[1].split("[,][\\s]*");
		ArrayList<Integer> keyCodes = new ArrayList<Integer>();

		for (int i = 0; i < keyNames.length; i++) {
			keyNames[i] = keyNames[i].toUpperCase();
			if (keyNames[i].length() > 1) {
				StupidUserMessage();
				return;
			}
			Integer keyCode = controlKeyNames.get(keyNames[i]);
			if (keyCode != null)
				keyCodes.add(keyCode);
		}

		game.getkeyboardState().PRORO_setKeysDown(keyCodes);
		game.Update();
		System.out.print("Update (");

		for (int i = 0; i < keyNames.length - 1; i++) {
			System.out.print(keyNames[i] + ",");
		}

		if (keyNames.length > 0)
			System.out.print(keyNames[keyNames.length - 1]);
		System.out.println(") Success");

		game.getkeyboardState().isKeyDown(0);
	}

	private static void Init(String[] commAndArgs) {
		game.Init();
		System.out.println("Init Success");
	}

	public static void DumpDumpable(Dumpable d, String name) {
		System.out.println(name + " " + d.getProtoId());
		System.out.println(repeat("-", 22));
		for (Entry<String, String> attr : d.dump().entrySet()) {
			System.out.println(attr.getKey() + ": " + attr.getValue());
		}

		System.out.println(repeat("-", 22));
		
	}

	public static <S extends Dumpable> void FindAndDump(List<S> list,
			String name, int id) {
		for (Dumpable d : list) {
			if (d.getProtoId() == id
					&& ClassOrSuperNameMatch(d.getClass(), name)) {
				DumpDumpable(d, name);
				return;
			}
		}
		System.out.println("Object not found");
	}

	private static void Dump(String[] commAndArgs) {

		String[] args = commAndArgs[1].split(" ");
		int id = -1;
		try {
			if (args.length > 1) {
				id = Integer.parseInt(args[1]);
			}
		} catch (NumberFormatException exp) {
			StupidUserMessage();
			return;
		}

		switch (args[0]) {
		case "Robot":
			FindAndDump(game.getRobots(), args[0], id);
			break;
		case "LittleBot":
			FindAndDump(game.getLittleBots(), args[0], id);
			break;
		case "Obstacle":
			FindAndDump(game.getObstacles(), args[0], id);
			break;
		case "Oil":
			FindAndDump(game.getObstacles(), args[0], id);
			break;
		case "Glue":
			FindAndDump(game.getObstacles(), args[0], id);
			break;
		case "Game":
			DumpDumpable(game, args[0]);
			break;
		default:
			System.out.println("This object not exist or not bumpable");
			break;
		}
	}

	private static void FindAndListId(List<? extends Dumpable> lst, String name) {
		System.out.print("Available " + name + " Ids: (");
		boolean firstOne = true;
		for (int i = 0; i < lst.size(); i++) {
			if (ClassOrSuperNameMatch(lst.get(i).getClass(), name))
			{
				System.out.print((firstOne ? "" : ",") + lst.get(i).getProtoId());
				firstOne = false;
			}
		}

		System.out.println(")");
	}

	private static void ListId(String[] commAndArgs) {
		String[] args = commAndArgs[1].split(" ");

		switch (args[0]) {
		case "Robot":
			FindAndListId(game.getRobots(), args[0]);
			break;
		case "LittleBot":
			FindAndListId(game.getLittleBots(), args[0]);
			break;
		case "Obstacle":
			FindAndListId(game.getObstacles(), args[0]);
			break;
		case "Oil":
			FindAndListId(game.getObstacles(), args[0]);
			break;
		case "Glue":
			FindAndListId(game.getObstacles(), args[0]);
			break;
		default:
			System.out.println("This object not exist or not bumpable");
			break;
		}
	}

	public static void CommandLoop() {
		System.out
				.println("Veletlen ertekek az akadalyok szamara\n(ha nincs megadva, veletlen lesz):");

		try {
			String[] ranStrs;
			String tmp = br.readLine().replace(';', ',');
			if (tmp.trim().length() > 0) {
				ranStrs = tmp.split(",");

				for (String str : ranStrs) {
					randoms.add(Double.parseDouble(str));
				}

				System.out.print("Random values: (");
				for (int i = 0; i < randoms.size(); i++) {
					System.out.print(LeaveDotZeroOr3Digit(randoms.get(i))
							+ (i != randoms.size() - 1 ? (i % 2 == 0) ? "," : ";" : ""));
				}
				System.out.println(")");
			}
		} catch (NumberFormatException exp) {
			randoms.clear();
			StupidUserMessage();
		} catch (IOException e) {
			System.out.print("Something went wrong. :(");
		}

		boolean conntinue = true;
		do {
			String[] commAndArgs = ReadCommandWithArguments();
			
			/*try
			{*/
				switch (commAndArgs[0]) {
				case "update":
					Update(commAndArgs);
					break;
				case "init":
					Init(commAndArgs);
					break;
				case "dump":
					Dump(commAndArgs);
					break;
				case "listid":
					ListId(commAndArgs);
					break;
				case "exit":
					conntinue = false;
					break;
				default:
					StupidUserMessage();
					break;
				}
			/*}
			catch (NullPointerException exp)
			{
				System.out.println("NullPointerException, The Game object maybe not initialized.\nPlease use Init command");
			}*/
			
		} while (conntinue);
		System.out.print("Test Sequence Ended");
	}

	public static double getNextRandomCodrinatePart() {
		if (randoms.size() > 0) {
			if (randIndex >= randoms.size())
				randIndex = 0;

			return randoms.get(randIndex++);
		}

		// att kell majd irni
		return (Math.random() * 1000);
	}

	/**
	 * A paraméterül kapott stringet ismétli meg n-szer
	 * 
	 * @param str
	 *            : a szöveg
	 * @param n
	 *            : ismétlés száma
	 * @return re: az előállított új szöveg
	 */
	private static String repeat(String str, int n) {
		String re = "";
		for (int i = 0; i < n; i++) {
			re += str;
		}
		return re;
	}

	private static boolean ClassOrSuperNameMatch(Class<?> cls, String name) {
		boolean clsNameMach = false;

		do {
			clsNameMach = cls.getSimpleName().equals(name);
			cls = cls.getSuperclass();
		} while (!clsNameMach && !cls.getSimpleName().equals("Object"));
		return clsNameMach;
	}

	public static String LeaveDotZeroOr3Digit(Double d) {
		NumberFormat numForm = NumberFormat.getInstance(Locale.ENGLISH);
		numForm.setGroupingUsed(false);
		numForm.setMinimumFractionDigits(0);
		numForm.setMaximumFractionDigits(3);

		return numForm.format(d);
	}
}
