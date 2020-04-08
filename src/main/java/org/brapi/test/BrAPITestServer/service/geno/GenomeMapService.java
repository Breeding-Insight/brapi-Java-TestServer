package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.geno.GenomeMapEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.LinkageGroupEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerEntity;
import org.brapi.test.BrAPITestServer.repository.geno.GenomeMapRepository;
import org.brapi.test.BrAPITestServer.repository.geno.LinkageGroupRepository;
import org.brapi.test.BrAPITestServer.repository.geno.MarkerRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.GenomeMap;
import io.swagger.model.geno.LinkageGroup;

@Service
public class GenomeMapService {

	private GenomeMapRepository genomeMapRepository;
	private LinkageGroupRepository linkageGroupRepository;
	private MarkerRepository markerRepository;

	@Autowired
	public GenomeMapService(GenomeMapRepository genomeMapRepository, LinkageGroupRepository linkageGroupRepository, MarkerRepository markerRepository) {
		this.genomeMapRepository = genomeMapRepository;
		this.linkageGroupRepository = linkageGroupRepository;
		this.markerRepository = markerRepository;
	}

	public List<GenomeMap> getMapSummaries(String speciesId, String commonCropName, String scientificName, String type, Metadata metaData) {
		
//		GenomeMapSearchRequest request = new GenomeMapSearchRequest(speciesId, commonCropName, scientificName, type);
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
//		Page<GenomeMap> summaries = genomeMapRepository.findBySearch(request, pageReq).map(this::convertFromEntity);

//		PagingUtility.calculateMetaData(metaData, summaries);
//		return summaries.getContent();
		return null;

	}

	private GenomeMap convertFromEntity(GenomeMapEntity entity) {
		GenomeMap summary = new GenomeMap();
		summary.setComments(entity.getComments());
		summary.setCommonCropName(entity.getCommonCropName());
		summary.setDocumentationURL(entity.getDocumentationURL());
		summary.setScientificName(entity.getScientificName());
		summary.setMapName(entity.getName());
		summary.setMapDbId(entity.getId());
//		summary.setName(entity.getName());
//		summary.setPublishedDate(DateUtility.toLocalDate(entity.getPublishedDate()));
//		summary.setSpecies(entity.getSpecies());
		summary.setType(entity.getType());
		summary.setUnit(entity.getUnit());

		summary.setLinkageGroupCount(entity.getLinkageGroups().size());
		entity.getLinkageGroups().forEach((group) -> {
			if(summary.getMarkerCount() == null) {
				summary.setMarkerCount(0);
			}
			summary.setMarkerCount(summary.getMarkerCount() + group.getMarkers().size());
		});
		return summary;
	}

	public GenomeMap getMapDetail(Metadata metaData, String mapDbId) {
		Optional<GenomeMapEntity> entityOption = genomeMapRepository.findById(mapDbId);
		GenomeMap detail = null;
		if (entityOption.isPresent()) {
			GenomeMapEntity entity = entityOption.get();
			detail = new GenomeMap();
			detail.setMapDbId(entity.getId());
			detail.setMapName(entity.getName());
//			detail.setName(entity.getName());
			detail.setType(entity.getType());
			detail.setUnit(entity.getUnit());
			detail.setDocumentationURL(entity.getDocumentationURL());

			Pageable pageReq = PagingUtility.getPageRequest(metaData);
			Page<LinkageGroupEntity> page = linkageGroupRepository.findAllByGenomeMapDbId(mapDbId, pageReq);
			PagingUtility.calculateMetaData(metaData, page);
				
			List<LinkageGroup> groups = page
					.stream()
					.map((linkageGroupEntity) -> {
				LinkageGroup linkageGroup = new LinkageGroup();
				linkageGroup.setLinkageGroupName(linkageGroupEntity.getLinkageGroupName());
				linkageGroup.setMarkerCount(linkageGroupEntity.getMarkers().size());
				linkageGroup.setMaxPosition(linkageGroupEntity.getMaxMarkerPosition());
				return linkageGroup;
			}).collect(Collectors.toList());

//			detail.setLinkageGroups(groups);
//			detail.setData(groups);
		}
		return detail;
	}
//
//	public List<MarkerSummaryMap> getMapPositions(String mapDbId, String linkageGroupName, Metadata metaData) {
//		return getMapPositionEntities(mapDbId, linkageGroupName, null, null, metaData).stream()
//				.map(this::convertFromEntityToSummaryMap)
//				.collect(Collectors.toList());
//	}
//
//	public List<MarkerSummaryLinkageGroup> getMapPositions(String mapDbId, String linkageGroupName, Integer min, Integer max, Metadata metaData) {
//		int minPosition = min == null ? -1 : min;
//		int maxPosition = max == null ? -1 : max;
//		Page<MarkerEntity> page = getMapPositionEntities(mapDbId, linkageGroupName, min, max, metaData);
//		PagingUtility.calculateMetaData(metaData, page);
//		List<MarkerSummaryLinkageGroup> data = page.stream()
//				.filter((entity) -> { 
//					return positionFilter(entity.getLocation().toString(), minPosition, maxPosition);
//				})
//				.map(this::convertFromEntityToSummaryLinkageGroup)
//				.collect(Collectors.toList());
//		return data;
//	}
//
//	private Page<MarkerEntity> getMapPositionEntities(String mapDbId, String linkageGroupName, Integer min, Integer max, Metadata metaData) {
//		Page<MarkerEntity> page = null;
//		Pageable pageReq = PagingUtility.getPageRequest(metaData);
//		
//		boolean nameb = linkageGroupName != null;
//		boolean minb = min != null;
//		boolean maxb = max != null;
//		if (nameb && minb && maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqualAndLocationLessThanEqual(mapDbId, linkageGroupName, min, max, pageReq);
//		}else if (nameb && minb && !maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqual(mapDbId, linkageGroupName, min, pageReq);
//		}else if (nameb && !minb && maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationLessThanEqual(mapDbId, linkageGroupName, max, pageReq);
//		}else if (nameb && !minb && !maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupName(mapDbId, linkageGroupName, pageReq);
//		}else if (!nameb && minb && maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqualAndLocationLessThanEqual(mapDbId, min, max, pageReq);
//		}else if (!nameb && minb && !maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqual(mapDbId, min, pageReq);
//		}else if (!nameb && !minb && maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbIdAndLocationLessThanEqual(mapDbId, max, pageReq);
//		}else if (!nameb && !minb && !maxb) {
//			page = markerRepository.findAllByLinkageGroup_GenomeMapDbId(mapDbId, pageReq);
//		}
//		PagingUtility.calculateMetaData(metaData, page);
//		return page;
//	}
//
//	private boolean positionFilter(String location, int minPosition, int maxPosition) {
//		int loc = Integer.parseInt(location);
//		return ((loc <= maxPosition || maxPosition < 0) && (loc >= minPosition || minPosition < 0));
//	}
//
//	private MarkerSummaryMap convertFromEntityToSummaryMap(MarkerEntity entity) {
//		MarkerSummaryMap marker = new MarkerSummaryMap();
//		marker.setLinkageGroupName(entity.getLinkageGroup().getLinkageGroupName());
//		marker.setLocation(entity.getLocation().toString());
//		marker.setMarkerDbId(entity.getId());
//		marker.setMarkerName(entity.getMarkerName());
//		return marker;
//	}
//	private MarkerSummaryLinkageGroup convertFromEntityToSummaryLinkageGroup(MarkerEntity entity) {
//		MarkerSummaryLinkageGroup marker = new MarkerSummaryLinkageGroup();
//		marker.setLocation(entity.getLocation().toString());
//		marker.setMarkerDbId(entity.getId());
//		marker.setMarkerName(entity.getMarkerName());
//		return marker;
//	}

}