using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class TrifonsQuest
{
    static void Main(string[] args)
    {
        long healthPoints = long.Parse(Console.ReadLine());
        int[] size = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();

        int rows = size[0];
        int cols = size[1];
        char[][] map = FillMap(rows, cols);

        StartQuest(map, rows, cols, healthPoints);
    }
    

    private static void StartQuest(char[][] map, int rows, int cols, long healthPoints)
    {
        uint turns = 0;
        bool alive = true;
        int deadRow = -1;
        int deadCol = -1;
        for (int col = 0; col < cols; col++)
        {
            if (col % 2 == 0)
            {
                for (int row = 0; row < rows; row++)
                {
                    char cell = map[row][col];
                    switch (cell)
                    {
                        case 'F': healthPoints -= turns / 2; break;
                        case 'H': healthPoints += turns / 3; break;
                        case 'T': turns += 2; break;
                        case 'E': break;
                    }
                    if (healthPoints <= 0)
                    {
                        deadRow = row;
                        deadCol = col;
                        alive = false;
                        break;
                    }
                    turns++;
                }
                if (!alive)
                {
                    break;
                }                
            }
            else
            {
                for (int row = rows - 1; row >= 0; row--)
                {
                    char cell = map[row][col];
                    switch (cell)
                    {
                        case 'F': healthPoints -= turns / 2; break;
                        case 'H': healthPoints += turns / 3; break;
                        case 'T': turns += 2; break;
                        case 'E': break;
                    }
                    if (healthPoints <= 0)
                    {
                        deadRow = row;
                        deadCol = col;
                        alive = false;
                        break;
                    }
                    turns++;
                }
                if (!alive)
                {
                    break;
                }
            }
        }

        PrintResults(deadRow, deadCol, healthPoints, turns);
    }

    private static void PrintResults(int deadRow, int deadCol, long healthPoints, uint turns)
    {
        if (deadRow == -1 && deadCol == -1)
        {
            Console.WriteLine("Quest completed!");
            Console.WriteLine($"Health: {healthPoints}");
            Console.WriteLine($"Turns: {turns}");
        }
        else
        {
            Console.WriteLine($"Died at: [{deadRow}, {deadCol}]");
        }
    }
    
    private static char[][] FillMap(int rows, int cols)
    {
        char[][] map = new char[rows][];

        for (int row = 0; row < rows; row++)
        {
            map[row] = Console.ReadLine().ToCharArray();
        }

        return map;
    }
}