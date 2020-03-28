package id.co.npad93.itemstore;

/**
 * 64 bit Xorshift implementation taken from the end of Sec. 3 (page 4) in
 * George Marsaglia, "Xorshift RNGs", Journal of Statistical Software, Vol.8
 * (Issue 14), 2003
 * Use an 'Xorshift*' variant, as shown here: http://xorshift.di.unimi.it
 * Completely based on LÖVE's <code>love.math.random()</code> as shown here
 * https://github.com/love2d/love/blob/master/src/modules/math/RandomGenerator.cpp
 */
public class Xorshift
{
	/**
	 * Create new Xorshift instance with specified seed
	 * 
	 * @param seed seed
	 */
	public Xorshift(long seed)
	{
		setSeed(seed);
	}

	/**
	 * Create new Xorshift instance with seed based on {@link System#nanoTime()}
	 */
	public Xorshift()
	{
		this(System.nanoTime() * 88172645463325252L);
	}

	/**
	 * Set the generator engine seed
	 * 
	 * @param seed seed
	 */
	public void setSeed(long seed)
	{
		// Xorshift isn't designed to give a good distribution of values across
		// many similar seeds, so we hash the state integer before using it.
		// http://www.reedbeta.com/blog/2013/01/12/quick-and-easy-gpu-random-numbers-in-d3d11/
		// Xorshift also can't handle a state value of 0, so we avoid that.
		do
		{
			seed = wangHash64(seed);
		} while (seed == 0);
		state = seed;
	}

	/**
	 * Return uniformly distributed pseudo random integer
	 * 
	 * @return pseudo random integer in [0,2^64)
	 */
	public long nextLong()
	{
		step();
		return state * 2685821657736338717L;
	}

	/**
	 * Get uniformly distributed pseudo random number in [0,1)
	 * 
	 * @return pseudo random number in [0,1)
	 */
	public double nextDouble()
	{
		return Double.longBitsToDouble(((0x3FFL) << 52) | (nextLong() >>> 12)) - 1.0;
	}

	private long state;

	private void step()
	{
		state ^= (state >>> 12);
		state ^= (state << 25);
		state ^= (state >>> 27);
	}

	/**
	 * Thomas Wang's 64-bit integer hashing function:
	 * https://web.archive.org/web/20110807030012/http://www.cris.com/%7ETtwang/tech/inthash.htm
	 * 
	 * @param key 64-bit integer to hash
	 * @return hashed 64-bit integer
	 */
	private static long wangHash64(long key)
	{
		key = (~key) + (key << 21); // key = (key << 21) - key - 1;
		key = key ^ (key >>> 24);
		key = (key + (key << 3)) + (key << 8); // key * 265
		key = key ^ (key >>> 14);
		key = (key + (key << 2)) + (key << 4); // key * 21
		key = key ^ (key >>> 28);
		key = key + (key << 31);
		return key;
	}
}
