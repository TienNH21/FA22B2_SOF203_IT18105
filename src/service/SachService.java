package service;

import java.util.ArrayList;
import model.Sach;
import repository.SachRepository;

public class SachService {
    private SachRepository sachRepo;

    public SachService()
    {
        this.sachRepo = new SachRepository();
    }
    
    public ArrayList<Sach> getAll() 
    {
        return this.sachRepo.getAll();
    }
    
    public boolean update(Sach s)
    {
        return this.sachRepo.update(s);
    }
    
    public boolean delete(int id)
    {
        return this.sachRepo.delete(id);
    }
}
