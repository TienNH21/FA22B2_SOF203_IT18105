package service;

import java.util.ArrayList;
import model.DanhMuc;
import repository.DanhMucRepository;

public class DanhMucService {
    private DanhMucRepository danhMucRepo;
    
    public DanhMucService()
    {
        this.danhMucRepo = new DanhMucRepository();
    }
    
    public boolean insert(DanhMuc danhMuc)
    {
        return this.danhMucRepo.insert(danhMuc);
    }
    
    public boolean update(DanhMuc danhMuc)
    {
        return this.danhMucRepo.update(danhMuc);
    }
    
    public boolean delete(DanhMuc danhMuc)
    {
        return this.danhMucRepo.delete(danhMuc);
    }
    
    public ArrayList<DanhMuc> all()
    {
        return this.danhMucRepo.all();
    }
}
