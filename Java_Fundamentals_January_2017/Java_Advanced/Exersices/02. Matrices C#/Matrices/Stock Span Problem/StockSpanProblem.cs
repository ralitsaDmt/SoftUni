namespace Stock_Span_Problem
{
    using System;
    using System.Collections.Generic;

    public class StockSpanProblem
    {
        public static void Main(string[] args)
        {
            int numberOfPrices = int.Parse(Console.ReadLine());

            Queue<decimal> prices = ReadPrices(numberOfPrices);
            List<int> spans = CalculateSpans(prices);

            Console.WriteLine("Spans:");
            Console.WriteLine(string.Join("\n", spans));
        }

        private static List<int> CalculateSpans(Queue<decimal> inPrices)
        {
            List<int> spans = new List<int>();

            Stack<decimal> outPrices = new Stack<decimal>();
            Stack<decimal> temp = new Stack<decimal>();

            while (inPrices.Count > 0)
            {
                decimal current = inPrices.Dequeue();

                if (outPrices.Count == 0)
                {
                    spans.Add(1);
                    outPrices.Push(current);
                }
                else
                {
                    if (current < outPrices.Peek())
                    {
                        outPrices.Push(current);
                        spans.Add(1);
                    }
                    else
                    {
                        int count = 1;
                        while (outPrices.Count > 0 && current >= outPrices.Peek())
                        {
                            temp.Push(outPrices.Pop());
                            count++;
                        }

                        while (temp.Count != 0)
                        {
                            outPrices.Push(temp.Pop());
                        }

                        outPrices.Push(current);
                        spans.Add(count);
                    }
                }
            }

            return spans;
        }

        private static Queue<decimal> ReadPrices(int n)
        {
            Queue<decimal> prices = new Queue<decimal>();
            for (int i = 0; i < n; i++)
            {
                prices.Enqueue(decimal.Parse(Console.ReadLine()));
            }
            return prices;
        }
    }
}
