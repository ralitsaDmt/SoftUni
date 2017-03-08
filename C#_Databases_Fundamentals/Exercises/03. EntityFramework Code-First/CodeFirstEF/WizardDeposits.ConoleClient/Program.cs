namespace WizardDeposits.ConoleClient
{
    using Data;

    class Program
    {
        static void Main(string[] args)
        {
            WizardDepositsContext context = new WizardDepositsContext();
            context.Database.Initialize(true);
        }
    }
}
