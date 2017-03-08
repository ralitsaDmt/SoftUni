using System;
using System.Data.SqlClient;

class GetVilliansNames
{
    static void Main()
    {
        string conString = @"Server=(localdb)\MSSQLLocalDB; Database=Minions; Trusted_Connection = True";
        SqlConnection con = new SqlConnection(conString);

        con.Open();
        using (con)
        {
            string selectCommand = "SELECT "
        }
    }
}
