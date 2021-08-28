import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Bai2_7 {
	private int n, m;
	private char[][] arr;
	Scanner scanner = new Scanner(System.in);
	
	public Bai2_7() {
		// TODO Auto-generated constructor stub
	}
	
	public Bai2_7(int n, int m) {
		this.n = n;
		this.m = m;
		this.arr= new char[n][m]; //khoi tao mang 2 chieu n hang m cot
	}

	public void nhap() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("arr["+i+"]["+j+"]= ");
				arr[i][j]= scanner.next().charAt(0);
			}
		}
	}
	
	public void xuat() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
// 	dem ki tu in hoa trong mang	
	public int kiTuHoa() {
		int dem=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] >='A' && arr[i][j]<='Z') {
					dem++;
				}
			}
		}
		return dem;
	}
	
//	chuyen ki tu thuong thanh hoa tren hang x
	public void thuongHoa(int x) {
		for (int i = 0; i < m; i++) {
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
		for (int i = 0; i < m; i++) {
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
		int hang, cot;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so hang: ");
		hang=Integer.parseInt(scanner.nextLine());
		System.out.println("Nhap so cot: ");
		cot= Integer.parseInt(scanner.nextLine());
		
		Bai2_7 test = new Bai2_7(hang, cot);
		test.nhap();
		test.xuat();
		System.out.println("So ki tu hoa: "+ test.kiTuHoa());
//		int x;
//		System.out.println("Nhap vao hang can chuyen thuong thanh hoa: ");
//		x= Integer.parseInt(scanner.nextLine());
//		test.thuongHoa(x);
		System.out.println("Mang sau khi chuyen: ");
		test.xuat();
		test.kiTuBien();
		
	}
		
}
