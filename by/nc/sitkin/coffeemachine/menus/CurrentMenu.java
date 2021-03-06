package by.nc.sitkin.coffeemachine.menus;

import by.nc.sitkin.coffeemachine.commands.*;
import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Person;
import by.nc.sitkin.coffeemachine.entities.User;

import java.util.List;

/**
 * Created by upsit on 22-Oct-16.
 */
public class CurrentMenu {
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setDefaultMenu(String startMenuDescription[], List<Person> persons, CoffeeMachine coffeeMachine) {
        Menu startMenu = new Menu(startMenuDescription);
        startMenu.setCommand("create user", new CreateUserCommand(persons));
        startMenu.setCommand("create admin", new CreateAdminCommand(persons, coffeeMachine));
        startMenu.setCommand("change person", new ChangePersonCommand(persons));
        startMenu.setCommand("exit", new ExitCommand(persons));
        this.menu = startMenu;
    }

    public void setUserMenu(String userMenuDescription[], User user, CoffeeMachine coffeeMachine){
        Menu userMenu = new Menu(userMenuDescription);
        userMenu.setCommand("select drink", new SelectDrinkCommand(coffeeMachine));
        userMenu.setCommand("pay money", new PayMoneyCommand(user));
        userMenu.setCommand("back", new BackCommand());
        this.menu = userMenu;
    }

    public void setAdminMenu(String adminMenuDescription[], Admin admin){
        Menu adminMenu = new Menu(adminMenuDescription);
        adminMenu.setCommand("fill machine", new FillMachineCommand(admin));
        adminMenu.setCommand("show status", new ShowStatusCommand(admin.getCoffeeMachine()));
        adminMenu.setCommand("back", new BackCommand());
        this.menu = adminMenu;
    }




}
