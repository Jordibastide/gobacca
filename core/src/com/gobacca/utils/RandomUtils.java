package com.gobacca.utils;

import com.gobacca.enums.EnemyType;
import com.gobacca.enums.PlatformType;

import java.util.Random;

public class RandomUtils
{

    public static float rangeRandom(float lower, float upper)
    {
    	return (float)(Math.random() * (upper - lower)) + lower;
    }
	
	public static EnemyType getRandomEnemyType()
    {
        RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
        return randomEnum.random();
    }
    
    public static PlatformType getRandomPlatformType()
    {
        RandomEnum<PlatformType> randomEnum = new RandomEnum<PlatformType>(PlatformType.class);
        return randomEnum.random();
    }

    private static class RandomEnum<E extends Enum<?>>
    {
    	private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token)
        {
            values = token.getEnumConstants();
        }

        public E random()
        {
            return values[RND.nextInt(values.length)];
        }
    }

}