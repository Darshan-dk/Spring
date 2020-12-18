package com.xworkz.electionresult.service;

import java.util.List;

import com.xworkz.electionresult.dao.ElectionDao;
import com.xworkz.electionresult.dto.ElectionResultDto;

public class ElectionResultServiceImpl implements ElectionResultService {

	private ElectionDao dao;

	public ElectionResultServiceImpl(ElectionDao dao) {
		System.out.println("Created " + this.getClass().getSimpleName());
		this.dao = dao;
	}

	@Override
	public String validateAndSave(ElectionResultDto dto) {
		String candidateName = dto.getName();
		int id = dto.getElectionId();

		int wardNo = dto.getWardNo();

		boolean valid = false;
		String message = "failed";

		if (dto != null) {
			System.out.println("dto is an object");

			if (candidateName != null && !candidateName.isEmpty()) {
				System.out.println("Candidate Name is  valid");
				valid = true;
			} else {

				System.out.println("Candidate Name is not valid");
				valid = false;
			}

			if (valid) {
				if (wardNo >= 1 && wardNo <= 500) {
					System.out.println("wardNo is  valid");
					valid = true;
				} else {

					System.out.println("wardNo is not valid");
					valid = false;
				}
			}
			if (valid) {
				if (id >= 0) {
					System.out.println("id is  valid");
					valid = true;
				} else {

					System.out.println("id is not valid");
					valid = false;
				}

			} else {

				if (valid) {
					dao.save(dto);
					message = "saved";
					System.out.println("Saved");
				} else {
					message = "failed";
					System.out.println("failed");
				}

			}

		}
		return message;
	}

	@Override
	public void validateAndDeleteById(int electionId) {
		// TODO Auto-generated method stub
		boolean valid = false;
		String message = "failed";

		if (electionId >= 0) {
			System.out.println("id is  valid");
			valid = true;
		} else {

			System.out.println("id is not valid");
			valid = false;
		}
		if (valid) {
			dao.deleteById(electionId);
			message = "deleted";
			System.out.println("deleted successfully");

		} else {
			message = "failed";
			System.out.println("delete operation failed");
		}
	}

	@Override
	public void validateAndupdateWardNoById(int electionId, int wardNo) {
		// TODO Auto-generated method stub
		boolean valid = false;
		String message = "failed";

		if (electionId >= 0) {
			System.out.println("id is  valid");
			valid = true;
		} else {

			System.out.println("id is not valid");
			valid = false;
		}
		if (valid) {
			if (wardNo >= 1 && wardNo <= 500) {
				System.out.println("wardNo is  valid");
				valid = true;
			} else {

				System.out.println("wardNo is not valid");
				valid = false;
			}
		}
		if (valid) {
			dao.updateWardNoById(electionId, wardNo);
			message = "Updated";
			System.out.println("Updated successfully");

		} else {
			message = "failed";
			System.out.println("Update operation failed");
		}

	}

	@Override
	public ElectionResultDto validateAndGetByPartyName(String name) {
		// TODO Auto-generated method stub
		ElectionResultDto dto = null;
		boolean valid = false;
		String message = "failed";

		if (name != null && !name.isEmpty()) {
			System.out.println("Candidate Name is  valid");
			valid = true;
		} else {

			System.out.println("Candidate Name is not valid");
			valid = false;
		}
		if (valid) {
			dao.getByPartyName(name);
			message = "Updated";
			System.out.println("Updated successfully");

		} else {
			message = "failed";
			System.out.println("Update operation failed");
		}
		return dto;
	}

	@Override
	public List<ElectionResultDto> validateAndGetList(ElectionResultDto dto) {
		// TODO Auto-generated method stub
		List<ElectionResultDto> dto2 = null;
		boolean valid = false;
		String message = "failed";

		if (dto != null) {
			System.out.println("dto is an object");
			dao.getList(dto);
		} else {
			System.out.println("dto cannot null");
		}

		return dto2;
	}

}
