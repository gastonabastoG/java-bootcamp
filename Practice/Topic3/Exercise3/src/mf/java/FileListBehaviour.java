package mf.java;

import java.io.File;
import java.util.ArrayList;

public class FileListBehaviour {

	ArrayList<File> list = new ArrayList<File>();
	int maxSizeOfList = 15;

	public FileListBehaviour(int size) {
		maxSizeOfList = size;
	}

	public void addFile(File file) {

		// find a file in list
		boolean isFileFound = false;
		for (File f : list) {
			if (f.getAbsolutePath() == file.getAbsolutePath()) {
				// if file exists in list, it is removed and is added to an
				// auxiliary list, then the list is added to auxiliary list.
				// Finally the auxiliary list replaces the list.
				// the purpose is to move the file at first position.
				File auxFile = list.remove(list.indexOf(f));
				ArrayList<File> auxList = new ArrayList<File>();
				auxList.add(auxFile);
				auxList.addAll(list);
				list.clear();
				list.addAll(auxList);
				isFileFound = true;
				break;
			}
		}
		if (!isFileFound && list.size() < maxSizeOfList) {
			// if the file no exists in list and the list is not full, then the
			// file is added to list
			list.add(file);
		}
	}

	// method that generates an array of Files, using Files that are in list.
	public File[] getFileArray() {
		File array[] = new File[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

}
