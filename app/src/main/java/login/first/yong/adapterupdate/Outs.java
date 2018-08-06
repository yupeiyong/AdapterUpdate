package login.first.yong.adapterupdate;

public class Outs {
    private int outerInt=100;
    public class Ins{
        private int innerInt=25;
        public void specialMethod(){
            System.out.println(outerInt);
            System.out.println(innerInt);
        }
    }
}
