package id.co.npad93.itemstore.interact;

import java.util.Scanner;

import id.co.npad93.itemstore.*;

abstract class Action
{
	public abstract String name();
	public abstract void action(User u, Xorshift rng, Scanner sc);
}
