package info.sandroalmeida;

/*
IF Root = 0
Father=p then left_son=(2*p)+1 and right_son=(2*p)+2

IF Root = 1
Father=p then left_son=(2*p) and right_son=(2*p)+1
* */

public class TreeArrayImpl {

    private int root;
    private String[] str;

    public TreeArrayImpl(int size){
        this.root = 0;
        this.str = new String[size];
    }

    /*create root*/
    public void Root(String key)
    {
        str[0] = key;
    }

    /*create left son of root*/
    public void set_Left(String key, int root)
    {
        int t = (root * 2) + 1;

        if(str[root] == null){
            System.out.printf("Can't set child at %d, no parent found\n",t);
        }else{
            str[t] = key;
        }
    }

    /*create right son of root*/
    public void set_Right(String key, int root)
    {
        int t = (root * 2) + 2;

        if(str[root] == null){
            System.out.printf("Can't set child at %d, no parent found\n",t);
        }else{
            str[t] = key;
        }
    }

    public void print_Tree()
    {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");

        }
    }

}
