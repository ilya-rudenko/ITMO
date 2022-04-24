package command;

import collections.MovieCollection;

public class CommandManager {
    Command add,update,remove,clear,minByOscarsCount,printAscending;
    Command show,save,load,execute,countGreater,help;
    Command exit,addIfMax,removeLower,returnHistory,info;

    public CommandManager(Command add,Command show,Command exit,Command update,Command remove,Command clear,Command save,Command load,Command execute,Command addIfMax,Command removeLower,Command returnHistory,Command minByOscarsCount, Command countGreater, Command printAscending,Command help,Command info){
        this.add=add;
        this.show=show;
        this.exit = exit;
        this.update=update;
        this.remove=remove;
        this.clear=clear;
        this.save=save;
        this.load=load;
        this.execute=execute;
        this.addIfMax=addIfMax;
        this.removeLower=removeLower;
        this.returnHistory=returnHistory;
        this.minByOscarsCount=minByOscarsCount;
        this.countGreater=countGreater;
        this.printAscending=printAscending;
        this.help=help;
        this.info=info;
    }

    public void add(){
        add.execute(null);
    }
    public void addIfMax(){ addIfMax.execute(null);}
    public void removeLower(){removeLower.execute(null);}

    public void show(){
        show.execute(null);
    }
    public void exit(){
        exit.execute(null);
    }
    public void update(String arg) {update.execute(arg);}
    public void remove(String arg) {remove.execute(arg);}
    public void clear() {clear.execute(null);}
    public void save(String arg) {save.execute(arg);}
    public void load(String arg) {load.execute(arg);}
    public void execute(String arg) {execute.execute(arg);}
    public void returnHistory() {returnHistory.execute(null);}
    public void minByOscarsCount(){minByOscarsCount.execute(null);}
    public void countGreater(String arg){countGreater.execute(arg);}
    public void printAscending(){printAscending.execute(null);}
    public void help(){help.execute(null);}
    public void info(){info.execute(null);}
}
