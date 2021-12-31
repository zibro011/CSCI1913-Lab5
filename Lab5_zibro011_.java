class Sieve
{
    private boolean[]numbers;
    private int max;

    public Sieve(int max)
    {
        numbers=new boolean[max]; //make an array of booleans called numbers
        if (max<2)
        {
            throw new IllegalArgumentException(); //raise exception if max is less than 2
        }
        else
        {
            this.max = max;
            numbers[0]=false; //set first two elements to false
            numbers[1]=false;
            for (int i = 2; i<max; i++)
            {
                numbers[i] = true; //set all other elements to true
            }
        }
    }

    public void findPrimes()
    {
        double limit = Math.sqrt(max);
        for (var p = 2; p <= limit; p++) //start at 2 bc the first two are always false
        {
                if (numbers[p])
                {
                    for( var j= p*p; j < max; j+= p)
                    {
                        numbers[j]=false;
                    }
                }
        }
    }

    public String toString()
    {
        String s=""; //create empty string s
        for (int e = 2; e<max; e++)
        {
            if (numbers[e])
            {
                s = s + e + " ";
            }
        }
        return s;

    }


}

    //
    //  SIEVE. The Sieve of Eratosthenes.
    //
    //    James B. Moen
    //    08 Oct 19
    //
    //  Test the SIEVE class, for 30 points total.
    //

    //
    //  Put your code for the class SIEVE here!!!
    //

    //  TOSS THE KNEES. Run SIEVE on some examples.

    class TossTheKnees {

    //  MAIN. Find some primes.

        public static void main(String[] args) {
            Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

    //  5 points. This must print "Sieve size must be at least 2." but without the
    //  quotes.

           try {
                sieve = new Sieve(0);
            } catch (IllegalArgumentException oops) {
                System.out.println("Sieve size must be at least 2.");
            }

    //  5 points. This must print nothing.

            try {
                sieve = new Sieve(100);
            } catch (IllegalArgumentException oops) {
                System.out.println("Sieve size must be at least 2.");
            }
    //  10 points. This must print integers from 2 to 99, separated by blanks.

            System.out.println(sieve);

    //  10 points. This must print the prime numbers between 2 and 99, separated by
    //  blanks. They are:
    //
    //  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

            sieve.findPrimes();
            System.out.println(sieve);
        }
    }
