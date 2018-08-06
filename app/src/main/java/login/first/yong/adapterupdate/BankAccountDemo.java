package login.first.yong.adapterupdate;

public class BankAccountDemo {
    public static void main(String[]args){
        System.out.println("creating a new account");
        BankAccount account=new BankAccount();
        account.makeDeposit("100.00");

        account.makeDeposit("99.99");
        account.makeDeposit("0.01");

        System.out.println(account.getBalance());

        OuterClass outer=new OuterClass();
        OuterClass.InnerClass.someMethod();

        Outs outs=new Outs();
        Outs.Ins ins=outs.new Ins();
        ins.specialMethod();
    }
}
