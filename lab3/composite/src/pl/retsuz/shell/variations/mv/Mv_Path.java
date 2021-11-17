package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Path extends CommandVariation {
    public Mv_Path(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]* [a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {

        String[] parameters = params.split(" ");
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        try {
            IComposite elem1 = c.findElementByPath(parameters[0]);
            IComposite elem2 = c.findElementByPath(parameters[1]);
            Composite.moveElement(elem1.getParent(), elem2, elem1);
        }catch(Exception e){
            System.out.println("Docelowy element nie jest katalogiem lub obecny katalog nie zawiera elementu.");
        }



    }
}
