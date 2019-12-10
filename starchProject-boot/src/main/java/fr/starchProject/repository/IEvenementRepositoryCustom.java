package fr.starchProject.repository;

import java.util.List;

import fr.starchProject.model.Evenement;

public interface IEvenementRepositoryCustom {
	List<Evenement> search(SearchCriteria searchCriteria);
}
