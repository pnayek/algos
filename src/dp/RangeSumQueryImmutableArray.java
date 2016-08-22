package dp;

public class RangeSumQueryImmutableArray {

	int[] nums;
	int[][] cache2d;
	int[] cache1d;

	public RangeSumQueryImmutableArray(int[] nums) {
		this.nums = nums;
		construct2dCache();
		construct1dCache();
	}

	private void construct2dCache() {
		cache2d = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			cache2d[i][i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				cache2d[i][j] = cache2d[i][j - 1] + nums[j];
			}
		}
	}
	
	private void construct1dCache() {
		cache1d = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				cache1d[i] = nums[i];
			else
				cache1d[i] = cache1d[i - 1] + nums[i]; 
		}
	}
	
	public int sumRange1d(int i, int j) {
		return cache1d[j] - cache1d[i];
	}
	
	public int sumRange2d(int i, int j) {
		return cache2d[i][j];
	}
}
