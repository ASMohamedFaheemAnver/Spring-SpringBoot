package org.freedom.showroom.services;

import java.util.List;

import org.freedom.showroom.hibernate.dao.BrandDAO;
import org.freedom.showroom.hibernate.entity.BrandEntity;

public class BrandService {

	BrandDAO brandDAO = new BrandDAO();

	public List<BrandEntity> getBrands() {
		return brandDAO.getBrands();
	}

	public void addBrand(BrandEntity brand) {
		brandDAO.addBrand(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) {
		brandDAO.updateBrand(updatedBrand);

	}

	public void deleteBrand(int brandId) {
		brandDAO.deleteBrand(brandId);

	}

	public BrandEntity getBrand(int brand_id) {
		return brandDAO.getBrand(brand_id);
	}

}
