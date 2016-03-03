package com.sample;

/**
 * Created by Laks on 1/16/16.
 */
public class Finally {

        public static void main(String []args)
        {

            try
            {
                String str = null;
                //System.exit(0);
                str.equals("");


            }


            catch(Exception e)
            {

                System.out.println("i am in catch block");
                System.exit(0);


            }

            finally
            {

                System.out.println("finally");
            }


        }
    }

