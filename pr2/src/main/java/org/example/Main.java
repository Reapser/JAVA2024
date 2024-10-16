import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        // Читання транзакцій
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        // Використання методів для аналізу
        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);
    }
}
