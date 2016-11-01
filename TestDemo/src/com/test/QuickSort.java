package com.test;

public class QuickSort   
{   
    //��ָ�������i��j��������Ԫ�ؽ���   
    private static void swap(DataWrap[] data, int i, int j)   
    {   
        DataWrap tmp;   
        tmp = data[i];   
        data[i] = data[j];   
        data[j] = tmp;   
    }   
    //��data�����д�start��end������Χ�������н��д���   
    //ʹ֮��������С�ڷֽ�ֵ�ķ�����ߣ����д��ڷֽ�ֵ�ķ����ұ�   
    private static void subSort(DataWrap[] data   
        , int start , int end)   
    {   
        //��Ҫ����   
        if (start < end)   
        {   
            //�Ե�һ��Ԫ����Ϊ�ֽ�ֵ   
            DataWrap base = data[start];   
            //i������������������ڷֽ�ֵ��Ԫ�ص�����   
            int i = start;   
            //j���ұ߿�ʼ����������С�ڷֽ�ֵ��Ԫ�ص�����   
            int j = end + 1;   
            while(true)   
            {   
                //�ҵ����ڷֽ�ֵ��Ԫ�ص���������i�Ѿ�����end��   
                while(i < end && data[++i].compareTo(base) <= 0);   
                //�ҵ�С�ڷֽ�ֵ��Ԫ�ص���������j�Ѿ�����start��   
                while(j > start && data[--j].compareTo(base) >= 0);   
                if (i < j)   
                {   
                    swap(data , i , j);   
                }   
                else  
                {   
                    break;   
                }   
            }   
            swap(data , start , j);   
            //�ݹ���������   
            subSort(data , start , j - 1);   
            //�ݹ��ұ�������   
            subSort(data , j + 1, end);   
        }   
    }   
    public static void quickSort(DataWrap[] data)    
    {   
        subSort(data , 0 , data.length - 1);   
    }   
    public static void main(String[] args)   
    {   
        DataWrap[] data = {   
            new DataWrap(9 , ""),   
            new DataWrap(-16 , ""),   
            new DataWrap(21 , "*"),   
            new DataWrap(23 , ""),   
            new DataWrap(-30 , ""),   
            new DataWrap(-49 , ""),   
            new DataWrap(21 , ""),   
            new DataWrap(30 , "*"),   
            new DataWrap(13 , "*")   
        };   
        System.out.println("����֮ǰ��\n"  
            + java.util.Arrays.toString(data));   
        quickSort(data);   
        System.out.println("����֮��\n"    
            + java.util.Arrays.toString(data));   
    }   
}   