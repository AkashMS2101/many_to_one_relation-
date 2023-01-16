package many_to_one_uni2.controller;

import java.util.ArrayList;
import java.util.List;

import many_to_one_uni2.dao.BranchDao;
import many_to_one_uni2.dto.Bank;
import many_to_one_uni2.dto.Branch;

public class SaveBranch {
	public static void main(String[] args) {
		Branch branch = new Branch();
		branch.setAddress("Hassan");
		branch.setIfsc("12354df655");
		branch.setManager("Mr.Rhoshan");
		branch.setPhone(984563217);
		
		Bank bank = new Bank();
		bank.setBank_name("SBI");
		bank.setCeo("Dont know");
		bank.setHead_office("Banglur");
		
		branch.setBank(bank);
		
		List<Branch> list = new ArrayList<Branch>();
		list.add(branch);
		BranchDao branchDao = new BranchDao();
		branchDao.saveBranch(list);
	}
}
