import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Bai2_7 {
	private char[][] arr= { {'a','F', 'a'}, {'g','b','C'},  {'h','I','Z'} };
	Scanner scanner = new Scanner(System.in);
	
	public Bai2_7() {
		// TODO Auto-generated constructor stub
	}
	
	public Bai2_7(int n, int m) {
	}

	public void xuat() {
		for (int i = 0; i <  arr.length; i++) {
			for (int j = 0; j <  arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
// 	dem ki tu in hoa trong mang	
	public int kiTuHoa() {
		int dem=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] >='A' && arr[i][j]<='Z') {
					dem++;
				}
			}
		}
		return dem;
	}
	
//	chuyen ki tu thuong thanh hoa tren hang x
	public void thuongHoa(int x) {
		for (int i = 0; i <  arr[0].length; i++) {
			if(arr[x][i] >='a' && arr[x][i]<='z') {	// neu ki tu o hang x, cot i la ki tu thuong thui chuyen thanh hoa
				arr[x][i] -=32;
			}
		}
	}
//	tim ki tu xuat kien o bien nhieu nhat
	public void kiTuBien() {
		int[] map = new int[255];
		
		for(int  i=0; i< 255; i++) {
			map[i]=0;
		}
//		lap qua hang dau tien va hang cuoi
		int n= arr.length;  //hang
		int m= arr[0].length; //cot
		for (int i = 0; i <  m; i++) {
			map[arr[0][i]]++; //phan tu hang dau tien
			map[arr[n-1][i]]++; //phan tu hang cuoi cung
		}
		
//		lap qua cot dau tien,cot cuoi (loai tru cac phan tu da trung lap o tren)
		for (int i = 1; i < n-1; i++) {
			map[arr[i][0]]++;	//phan tu cot dau tien
			map[arr[i][m-2]]++;	//phan tu cot cuoi cung
		}
		
		int max=map[0];
		int index=0;
		for (int i = 1; i < 255; i++) {
			if(map[i] > max) {
				max= map[i];
				index=i;
			}
		}
		System.out.println("Ki tu "+ (char)index+" xuat hien nhieu nhat: " + max+" lan" );
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Bai2_7 test = new Bai2_7();
		test.xuat();
		System.out.println("So ki tu hoa: "+ test.kiTuHoa());

		test.thuongHoa(1);
		System.out.println("Mang sau khi chuyen: ");
		test.xuat();
		test.kiTuBien();
		
	}
		
}
