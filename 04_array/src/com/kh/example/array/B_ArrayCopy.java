package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	// 얕은 복사 : 배열의 주소만 복사
	// 깊은 복사 : 동일한 새로운 배열을 하나 생성하여 실제 내부 값 복사
	//       1) for문     2) System.arraycopy    3) Arrays.copyOf     4) clone (사용 x)
	public void method1() {
		int[] originArr= {1, 2, 3, 4, 5}; // 선언과 동시에 초기화
		int[] copyArr = originArr; // 얕은 복사. 주소값을 copyArr에 집어넣음
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();
			
		// 사본 배열의 0번째를 바꿨음에도 불구하고 원본 배열도 바뀜 (같은 주소값을 가지고 있어서)
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// 원본배열과 사본 배열이 서로 참조하고 있는 배열이 같음 (주소값이 같음)
	}
	
	public void method2() {
		// for문을 이용한 깊은 복사
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[originArr.length]; // originArr의 길이만큼의 새로운 배열을 만들어줌 (다른 주소)
		
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];
			// copy에 값을 복사해서 집어넣음. 따라서 copyArr이 내가 값을 집어넣을 공간, originArr이 오른쪽에 값으로 들어감
			// copyArr = originArr이라고 하면 주소값을 가진 변수들이기 때문에 대괄호를 사용하여 실제 값을 가져와야 함
		}
		
		System.out.println("originArr : " + originArr); // [I@6d06d69c
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr); // [I@7852e922
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		// 주소가 다름 : 독립된 공간
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();

		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// 원본 배열과 사본 배열이 서로 참조하고 있는 배열이 다름 (주소값이 다름)
	}
	
	public void method3() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// System.arraycopy() 이용한 복사
		// System.arraycopy(src, srcPos, dest, destPos, length);
		//    src : 원본 배열
		//    srcPos : src에 대한 포지션 -> 원본 배열에서 복사를 시작할 위치
		//    dest : 복사 배열 (사본 배열)
		//    destPos : 복사 배열에서 붙여넣기를 시작할 위치
		//    length  : 복사 길이 (얼마나 복사할지)
		
		// 원본 배열의 0번째에서부터 원본 배열의 길이만쿰 복사 후, 복사 배열 3번째서부터 붙여넣기
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		originArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
	}
	
	public void method4() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// Arrays.copyOf 이용한 깊은 복사
		// Arrays.copyOf(original, newLength) -> 반환값 int[]
		//     original : 원본 배열
		//     newLength : 복사할 길이
		// copy한 것을 내뱉어줌 -> 복사 후 복사된 배열을 만들어 준다는 것
		// 어디에 붙여넣을지 명시하지 않고 복사할 것만 명시해 놓음 -> 복사한 것을 반환하는 것
		
		copyArr = Arrays.copyOf(originArr, originArr.length);
		
		// copyOf + ctrl + 클릭하면 다음과 같은 메소드의 원형을 확인 가능
//		public static int[] copyOf(int[] original, int newLength) {
//	        int[] copy = new int[newLength]; // newLenght개짜리 새로운 배열을 만들고 있음
//	        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength)); // 새로운 배열에 기존 배열을 복사
//	        return copy; // 복사된 새로운 배열의 주소값을 copyArr에 대입 
//	    }
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		originArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
	}
}
