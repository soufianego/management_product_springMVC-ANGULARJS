package org.sid.dao;
import java.util.List;


import javax.validation.Valid;

import org.sid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
	

	@Autowired
	private TestRepository testRepository ;
		
	
	
	@RequestMapping(value="/chercherProduits",method=RequestMethod.GET)
	public Page<Produit> chercher(
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="2")int s,
			@RequestParam(name="mc",defaultValue="")String mc)
	{ //pour faire la paggination, c a d : pour retourner les elements page par page on utilise avec spring data
		//Page<Produit> pageProduits= produitRepository.findAll(new PageRequest(p,s));
			return produitRepository.chercherProduits("%"+mc+"%",new PageRequest(p,s));
	}

	

	@RequestMapping(value="/tests",method=RequestMethod.GET)
	public Page<Test> listtest(
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="2")int s	
			)
	{
	return testRepository.findAll(new PageRequest(p,s));
		
	}
	
	@RequestMapping(value="/list_produits",method=RequestMethod.GET)
	public List<Produit> listProduits()
	{
	return produitRepository.findAll();
		
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public Page<Produit> listProduit(
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="2")int s	
			)
	{
	return produitRepository.findAll(new PageRequest(p,s));
		
	}
@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
public Produit getProduit(@PathVariable ("id") Long id){
return produitRepository.findOne(id);
}

@RequestMapping(value="/produits",method=RequestMethod.POST)
public Produit saveProduit(@Valid @RequestBody Produit p){
produitRepository.save(p);
return p;
}

@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
public Produit update(@Valid @RequestBody Produit p,@PathVariable ("id") Long id){

	p.setId(id);
	return produitRepository.saveAndFlush(p);

}

@RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE)
public void delete(@PathVariable ("id") Long id){

	
 produitRepository.delete(id);

}

}
