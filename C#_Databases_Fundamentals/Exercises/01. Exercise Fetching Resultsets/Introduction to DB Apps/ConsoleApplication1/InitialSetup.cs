using System;
using System.Data.SqlClient;

class InitialSetup
{
    static void Main()
    {
        string connectionString = @"Server=(localdb)\MSSQLLocalDB;Trusted_Connection=True";
        SqlConnection con = new SqlConnection(connectionString);
        
        con.Open();
        using (con)
        {
            CreateDatabase(con);            
        }

        connectionString = @"Server=(localdb)\MSSQLLocalDB; Database=MinionsDB; Trusted_Connection=True";
        con = new SqlConnection(connectionString);

        con.Open();
        using (con)
        {
            CreateTables(con);
        }       
    }

    private static void CreateTables(SqlConnection con)
    {
        string createTableTowns = "CREATE TABLE Towns " +
                "(" +
                "TownId INT PRIMARY KEY IDENTITY, " +
                "Name VARCHAR(50), " +
                "Country VARCHAR(50) " +
                ")";

        string createTableMinions = "CREATE TABLE Minions " +
                "(" +
                "MinionId INT PRIMARY KEY IDENTITY " +
                "Name VARCHAR(50), " +
                "Age INT, " +
                "TownId INT, " +
                "CONSTRAINT FK_Minions_Towns FOREIGN KEY (TownId) " +
                "REFERENCES Towns(TownId) " +
                ")";

        string createTableVilians = "CREATE TABLE Villians " +
                "(" +
                "VillianId INT PRIMARY KEY IDENTITY, " +
                "Name VARCHAR(50), " +
                "EvilnessFactor VARCHAR(50), " +
                "CONSTRAINT Chk_EvilnessFactor CHECK(Chk_EvilnessFactor in ('good', 'bad', 'evil', 'super evil')) " +
                ")";

        string createTableMinionsVillians = "CREATE TABLE  MinionsVillians " +
                "(" +
                "MinionId INT, " +
                "VillianId INT, " +
                "CONSTRAINT FK_MinionsVillians_Minions FOREIGN  KEY (MinionID) " +
                "REFERENCES Minions(MinionId), " +
                "CONSTRAINT FK_MinionsVillians_Villians FOREIGN KEY (VillianId) " +
                "REFERENCES Villians(VillianId), " +
                "CONSTRAINT PK_MinionsVillians PRIMARY KEY (MinionId, VillianId) " +
                ")";

        CreateTable(createTableTowns, con);
        CreateTable(createTableMinions, con);
        CreateTable(createTableVilians, con);
        CreateTable(createTableMinionsVillians, con);
    }

    private static void CreateTable(string stringCommand, SqlConnection con)
    {
        SqlCommand command = new SqlCommand(stringCommand, con);
        command.ExecuteNonQuery();
    }

    private static void CreateDatabase(SqlConnection con)
    {
        string createCommand = "CREATE DATABASE MinionsDB";
        SqlCommand command = new SqlCommand(createCommand, con);
        Console.WriteLine(command.ExecuteNonQuery());
    }
}
