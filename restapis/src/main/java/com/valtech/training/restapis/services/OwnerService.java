package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	/*
	 * from OwnerVO get the Owner
	 * create Owner on DB
	 * create OwnerVO from Owner
	 * return OwnerVO.
	 */
	OwnerVO createOwner(OwnerVO ownerVO);

	/*
	 * from OwnerVO get the Owner
	 * update owner on DB
	 * return owner
	 */
	OwnerVO updateOwner(long id, OwnerVO ownerVO);

	OwnerVO getOwner(long id);

	List<OwnerVO> getOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}