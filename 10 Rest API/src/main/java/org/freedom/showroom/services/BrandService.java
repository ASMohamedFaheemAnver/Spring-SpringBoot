package org.freedom.showroom.services;

import java.util.List;

import org.freedom.showroom.dao.BrandDAO;
import org.freedom.showroom.model.Brand;

public class BrandService {

	BrandDAO brandDAO = new BrandDAO();

	public List<Brand> getBrands() {
		return brandDAO.getBrands();
	}

	public void addBrand(Brand brand) {
		brandDAO.addBrand(brand);
	}

	public void updateBrand(Brand updatedBrand) {
		brandDAO.updateBrand(updatedBrand);

	}

	public void deleteBrand(int brandId) {
		brandDAO.deleteBrand(brandId);

	}

	public Brand getBrand(int brand_id) {
		return brandDAO.getBrand(brand_id);
	}

}
