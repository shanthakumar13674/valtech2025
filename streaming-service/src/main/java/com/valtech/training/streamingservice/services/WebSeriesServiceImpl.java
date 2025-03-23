package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.entities.WebSeries;
import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation =Propagation.REQUIRED )
public class WebSeriesServiceImpl implements WebSeriesService {
	
	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
	@Override
	public WebSeriesVO createorUpdate(WebSeriesVO w) {
		return WebSeriesVO.from(webSeriesRepo.save(w.to()));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeries(){
		return WebSeriesVO.from(webSeriesRepo.findAll());
	}
	
	@Override
	public WebSeriesVO getWebSeries(long id) {
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	@Override
	public List<WebSeriesVO> getAllByEpisodeCount(int count){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeCount(count));
	}
	
	@Override
	public List<WebSeriesVO> getAllByEpisodeDuration(long duration){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeDuration(duration));
	}
	
	

	
}
