package mf.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import mf.java.FileListBehaviour;

public class FileListBehaviourTest {

	FileListBehaviour flb;
	File f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16;

	@Before
	public void setUp() {
		flb = new FileListBehaviour(15);

		f1 = new File("C://testfile1.txt");
		f2 = new File("C://testfile2.txt");
		f3 = new File("C://testfile3.txt");
		f4 = new File("C://testfile4.txt");
		f5 = new File("C://testfile5.txt");
		f6 = new File("C://testfile6.txt");
		f7 = new File("C://testfile7.txt");
		f8 = new File("C://testfile8.txt");
		f9 = new File("C://testfile9.txt");
		f10 = new File("C://testfile10.txt");
		f11 = new File("C://testfile11.txt");
		f12 = new File("C://testfile12.txt");
		f13 = new File("C://testfile13.txt");
		f14 = new File("C://testfile14.txt");
		f15 = new File("C://testfile15.txt");
		f16 = new File("C://testfile16.txt");
	}

	@Test
	public void test1() {
		// empty testing
		File[] array = new File[0];
		assertArrayEquals(array, flb.getFileArray());
	}

	@Test
	public void test2() {
		// some files added testing
		File[] arrayExpected = new File[5];

		arrayExpected[0] = f1;
		arrayExpected[1] = f2;
		arrayExpected[2] = f3;
		arrayExpected[3] = f4;
		arrayExpected[4] = f5;

		flb.addFile(f1);
		flb.addFile(f2);
		flb.addFile(f3);
		flb.addFile(f4);
		flb.addFile(f5);

		assertArrayEquals(arrayExpected, flb.getFileArray());
	}

	@Test
	public void test3() {
		// add f7 file that exist in full list, list should move it at first
		// position.
		File[] arrayExpected = new File[15];
		arrayExpected[0] = f7;
		arrayExpected[1] = f1;
		arrayExpected[2] = f2;
		arrayExpected[3] = f3;
		arrayExpected[4] = f4;
		arrayExpected[5] = f5;
		arrayExpected[6] = f6;
		arrayExpected[7] = f8;
		arrayExpected[8] = f9;
		arrayExpected[9] = f10;
		arrayExpected[10] = f11;
		arrayExpected[11] = f12;
		arrayExpected[12] = f13;
		arrayExpected[13] = f14;
		arrayExpected[14] = f15;

		flb.addFile(f1);
		flb.addFile(f2);
		flb.addFile(f3);
		flb.addFile(f4);
		flb.addFile(f5);
		flb.addFile(f6);
		flb.addFile(f7);
		flb.addFile(f8);
		flb.addFile(f9);
		flb.addFile(f10);
		flb.addFile(f11);
		flb.addFile(f12);
		flb.addFile(f13);
		flb.addFile(f14);
		flb.addFile(f15);

		flb.addFile(f7); // adding a file that exist in list.

		assertArrayEquals(arrayExpected, flb.getFileArray());
	}

	@Test
	public void test4() {

		// add f16 file. it does not exist in full list, list should reject it.
		File[] arrayExpected = new File[15];
		arrayExpected[0] = f1;
		arrayExpected[1] = f2;
		arrayExpected[2] = f3;
		arrayExpected[3] = f4;
		arrayExpected[4] = f5;
		arrayExpected[5] = f6;
		arrayExpected[6] = f7;
		arrayExpected[7] = f8;
		arrayExpected[8] = f9;
		arrayExpected[9] = f10;
		arrayExpected[10] = f11;
		arrayExpected[11] = f12;
		arrayExpected[12] = f13;
		arrayExpected[13] = f14;
		arrayExpected[14] = f15;

		flb.addFile(f1);
		flb.addFile(f2);
		flb.addFile(f3);
		flb.addFile(f4);
		flb.addFile(f5);
		flb.addFile(f6);
		flb.addFile(f7);
		flb.addFile(f8);
		flb.addFile(f9);
		flb.addFile(f10);
		flb.addFile(f11);
		flb.addFile(f12);
		flb.addFile(f13);
		flb.addFile(f14);
		flb.addFile(f15);

		flb.addFile(f16); // file that not exist in full list.

		assertArrayEquals(arrayExpected, flb.getFileArray());

	}

}
