package test2;



public class Palindrome {
	class StackLong {
		long[] arr;
		int m = -1;

		public StackLong(int i) {
			arr = new long[i];
		}

		public void push(long a) {
			arr[++m] = a;
		}

		public long pop() {
			return arr[m--];
		}

		public boolean isEmpty() {
			if (m == -1)
				return true;
			else
				return false;
		}

		public int getSize() {
			return m + 1;
		}
	}

	public boolean checkPalindrome(long a) {
		String palindrome = Long.toString(a);
		StringBuilder reverse = new StringBuilder(palindrome).reverse();
		String reversepal = String.valueOf(reverse);
		if (palindrome.equals(reversepal))
			return true;
		else
			return false;
	}

	public long findMax(int n) {
		int dec = 10;
		long number = 1;
		for (int j = n; j > 0; j--) {
			number *= dec;
		}
		long consta = 1;
		for (int j = n - 1; j > 0; j--) {
			consta *= dec;
		}
		number--; 

		long res = 1;

		long[] arr = new long[(int) number - 1];

		long maxmul = number * number;

		foo: for (long outer_number_2 = number; outer_number_2 >= consta; outer_number_2--) {
			long outer_number_1 = number;
			long maxmulouter = outer_number_1 * outer_number_2;
			long maxmulinner = 0;

			long inner_number_1_mminner = 0;
			long inner_number_2_mminner = 0;

			if (checkPalindrome(maxmulouter)) {
				res = maxmulouter;
				System.out.println(outer_number_1 + " " + outer_number_2);
				break foo;
			}

			if (maxmulouter < maxmul) {

				int counter = 0;

				foo2: for (long inner_number_1 = number - 1; inner_number_1 >= outer_number_2; inner_number_1--) {
					if (arr[((int) (inner_number_1 - 1))] == 0) {
						arr[((int) inner_number_1 - 1)] = inner_number_1;
					}

					long inner_number_2 = arr[((int) inner_number_1 - 1)];

					long tempmminner = inner_number_1 * inner_number_2;

					if (checkPalindrome(tempmminner)) {
						res = tempmminner;
						System.out.println(inner_number_1 + " " + inner_number_2);
						break foo;
					}

					if (tempmminner < maxmul) {
						if (maxmulinner < tempmminner) {
							maxmulinner = tempmminner;
							inner_number_1_mminner = inner_number_1;
							inner_number_2_mminner = inner_number_2;
						}

					} else {
						arr[((int) (inner_number_1 - 1))] = --inner_number_2;
						inner_number_1++;

					}
				}
				if (maxmulouter > maxmulinner) {
					maxmul = maxmulouter;
				} else {
					maxmul = maxmulinner;
					arr[((int) (inner_number_1_mminner - 1))] = inner_number_2_mminner - 1;
					outer_number_2++;
				}
			} else {
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Palindrome a = new Palindrome();
		System.out.println(a.findMax(3));
	}
}
