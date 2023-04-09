import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {

	File f;
	String dirPath;
	String pathofFileToDelete;
	String pathOfFileGiven;
	String fileToSearch;
	String directoryPath;
	Scanner sc = new Scanner(System.in);

	public void ListFiles() {

		System.out.println("Enter the directory path to list files : ");
		dirPath = sc.next();
		f = new File(dirPath);
		File[] fileList = f.listFiles();

		Arrays.sort(fileList);
		for (File file : fileList) {
			System.out.println(file);
		}

	}

	public void addFile()

	{
		System.out.println("Enter the directory/file/");
		f = new File("C:\\Folder1\\file1.txt"); // initialize File object and passing path as argument
		boolean result;
		try {
			result = f.createNewFile();
			if (result) {
				System.out.println("file created succesfully at location - " + f.getCanonicalPath());
			} else {
				System.err.println("File already exist at location: " + f.getCanonicalPath());

			}

		}

		catch (IOException e) {
			e.printStackTrace(); // prints exception if any
		}

	}

	public void deleteFile() {

		System.out.println("Enter the path of file you want to delete:");
		pathofFileToDelete = sc.next();
		try {
			f = new File(pathofFileToDelete); // file to be delete
			if (f.delete()) // returns Boolean value
			{
				System.out.println("Deleted file -" + f.getName() + " at location " + f.getCanonicalPath());
			} else {
				System.err.println("Failed to delete File , File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchFiles() {

		System.out.println("Enter the directory/drive/file path from where you want to search file.");
		directoryPath = sc.next();
		System.out.println("Enter the name of file you want to search.");
		fileToSearch = sc.next();
		f = new File(directoryPath);
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File f, String name) {
				return name.equalsIgnoreCase(fileToSearch);
			}
		};
		String[] files = f.list(filter);
		if (files == null) {
			System.err.println("File Not Found at location");
		} else {
			System.out.println("File Found at location");
		}

	}

	public void details() {
		System.out.println("Deepak Aiwale");
		System.out.println("Welcomes you to LockedMe.com");

	}

	public void exitFromApp() {
		System.out.println("Thanks for visting LockedMe.com");
		System.exit(0);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LockedMe lm = new LockedMe();
		lm.details();
		int choice;
		String subChoice;
		do {
			System.out.println("Enter your choice");
			System.out.println("1. List all the files in directory");
			System.out.println("2. To enter into add/delete search operations");
			/*
			 * System.out.println("3. Add a file to directory");
			 * System.out.println("4. Delete a file from directory");
			 * System.out.println("4. Search for a file in given directory");
			 */
			System.out.println("3. Close the Application");

			choice = sc.nextInt();

			choice: switch (choice) {
			case 1:
				lm.ListFiles();
				break;
			case 2:

				do {

					System.out.println("a. Add a file to directory");
					System.out.println("b. Delete a file from directory");
					System.out.println("c. Search for a file in given directory");
					System.out.println("d. Navigate back to main menu");
					subChoice = sc.next();

					switch (subChoice) {
					case "a":
						lm.addFile();
						break;
					case "b":
						lm.deleteFile();
						break;
					case "c":
						lm.searchFiles();
						break;
					case "d":
						System.out.println("Back to main Menu");
						break choice;
					default:
						System.err.println("Invalid choice");
						break;

					}

				} while (subChoice != "d");

			case 3:
				lm.exitFromApp();
				break;
			default:
				System.out.println("Please Enter correct choice");
				break;
			}

		} while (choice != 5);

	}

}
