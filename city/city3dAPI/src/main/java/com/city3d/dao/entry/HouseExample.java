package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(String value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(String value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(String value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(String value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(String value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLike(String value) {
            addCriterion("house_id like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotLike(String value) {
            addCriterion("house_id not like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<String> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<String> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(String value1, String value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(String value1, String value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(String value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(String value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(String value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(String value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(String value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLike(String value) {
            addCriterion("add_id like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotLike(String value) {
            addCriterion("add_id not like", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<String> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<String> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(String value1, String value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(String value1, String value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(String value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(String value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(String value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(String value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(String value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(String value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLike(String value) {
            addCriterion("paper_id like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotLike(String value) {
            addCriterion("paper_id not like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<String> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<String> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(String value1, String value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(String value1, String value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andBuildDateIsNull() {
            addCriterion("build_date is null");
            return (Criteria) this;
        }

        public Criteria andBuildDateIsNotNull() {
            addCriterion("build_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDateEqualTo(String value) {
            addCriterion("build_date =", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotEqualTo(String value) {
            addCriterion("build_date <>", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateGreaterThan(String value) {
            addCriterion("build_date >", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateGreaterThanOrEqualTo(String value) {
            addCriterion("build_date >=", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLessThan(String value) {
            addCriterion("build_date <", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLessThanOrEqualTo(String value) {
            addCriterion("build_date <=", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLike(String value) {
            addCriterion("build_date like", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotLike(String value) {
            addCriterion("build_date not like", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateIn(List<String> values) {
            addCriterion("build_date in", values, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotIn(List<String> values) {
            addCriterion("build_date not in", values, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateBetween(String value1, String value2) {
            addCriterion("build_date between", value1, value2, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotBetween(String value1, String value2) {
            addCriterion("build_date not between", value1, value2, "buildDate");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIsNull() {
            addCriterion("house_url is null");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIsNotNull() {
            addCriterion("house_url is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUrlEqualTo(String value) {
            addCriterion("house_url =", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotEqualTo(String value) {
            addCriterion("house_url <>", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlGreaterThan(String value) {
            addCriterion("house_url >", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("house_url >=", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLessThan(String value) {
            addCriterion("house_url <", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLessThanOrEqualTo(String value) {
            addCriterion("house_url <=", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLike(String value) {
            addCriterion("house_url like", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotLike(String value) {
            addCriterion("house_url not like", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIn(List<String> values) {
            addCriterion("house_url in", values, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotIn(List<String> values) {
            addCriterion("house_url not in", values, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlBetween(String value1, String value2) {
            addCriterion("house_url between", value1, value2, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotBetween(String value1, String value2) {
            addCriterion("house_url not between", value1, value2, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlIsNull() {
            addCriterion("panorama_url is null");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlIsNotNull() {
            addCriterion("panorama_url is not null");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlEqualTo(String value) {
            addCriterion("panorama_url =", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlNotEqualTo(String value) {
            addCriterion("panorama_url <>", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlGreaterThan(String value) {
            addCriterion("panorama_url >", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("panorama_url >=", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlLessThan(String value) {
            addCriterion("panorama_url <", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlLessThanOrEqualTo(String value) {
            addCriterion("panorama_url <=", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlLike(String value) {
            addCriterion("panorama_url like", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlNotLike(String value) {
            addCriterion("panorama_url not like", value, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlIn(List<String> values) {
            addCriterion("panorama_url in", values, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlNotIn(List<String> values) {
            addCriterion("panorama_url not in", values, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlBetween(String value1, String value2) {
            addCriterion("panorama_url between", value1, value2, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andPanoramaUrlNotBetween(String value1, String value2) {
            addCriterion("panorama_url not between", value1, value2, "panoramaUrl");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(String value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(String value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(String value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(String value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(String value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLike(String value) {
            addCriterion("begin_date like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotLike(String value) {
            addCriterion("begin_date not like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<String> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<String> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(String value1, String value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(String value1, String value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosIsNull() {
            addCriterion("building_photos is null");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosIsNotNull() {
            addCriterion("building_photos is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosEqualTo(String value) {
            addCriterion("building_photos =", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosNotEqualTo(String value) {
            addCriterion("building_photos <>", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosGreaterThan(String value) {
            addCriterion("building_photos >", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosGreaterThanOrEqualTo(String value) {
            addCriterion("building_photos >=", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosLessThan(String value) {
            addCriterion("building_photos <", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosLessThanOrEqualTo(String value) {
            addCriterion("building_photos <=", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosLike(String value) {
            addCriterion("building_photos like", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosNotLike(String value) {
            addCriterion("building_photos not like", value, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosIn(List<String> values) {
            addCriterion("building_photos in", values, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosNotIn(List<String> values) {
            addCriterion("building_photos not in", values, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosBetween(String value1, String value2) {
            addCriterion("building_photos between", value1, value2, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuildingPhotosNotBetween(String value1, String value2) {
            addCriterion("building_photos not between", value1, value2, "buildingPhotos");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureIsNull() {
            addCriterion("bulding_structure is null");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureIsNotNull() {
            addCriterion("bulding_structure is not null");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureEqualTo(String value) {
            addCriterion("bulding_structure =", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureNotEqualTo(String value) {
            addCriterion("bulding_structure <>", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureGreaterThan(String value) {
            addCriterion("bulding_structure >", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureGreaterThanOrEqualTo(String value) {
            addCriterion("bulding_structure >=", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureLessThan(String value) {
            addCriterion("bulding_structure <", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureLessThanOrEqualTo(String value) {
            addCriterion("bulding_structure <=", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureLike(String value) {
            addCriterion("bulding_structure like", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureNotLike(String value) {
            addCriterion("bulding_structure not like", value, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureIn(List<String> values) {
            addCriterion("bulding_structure in", values, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureNotIn(List<String> values) {
            addCriterion("bulding_structure not in", values, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureBetween(String value1, String value2) {
            addCriterion("bulding_structure between", value1, value2, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andBuldingStructureNotBetween(String value1, String value2) {
            addCriterion("bulding_structure not between", value1, value2, "buldingStructure");
            return (Criteria) this;
        }

        public Criteria andCancelledIsNull() {
            addCriterion("cancelled is null");
            return (Criteria) this;
        }

        public Criteria andCancelledIsNotNull() {
            addCriterion("cancelled is not null");
            return (Criteria) this;
        }

        public Criteria andCancelledEqualTo(String value) {
            addCriterion("cancelled =", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledNotEqualTo(String value) {
            addCriterion("cancelled <>", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledGreaterThan(String value) {
            addCriterion("cancelled >", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledGreaterThanOrEqualTo(String value) {
            addCriterion("cancelled >=", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledLessThan(String value) {
            addCriterion("cancelled <", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledLessThanOrEqualTo(String value) {
            addCriterion("cancelled <=", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledLike(String value) {
            addCriterion("cancelled like", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledNotLike(String value) {
            addCriterion("cancelled not like", value, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledIn(List<String> values) {
            addCriterion("cancelled in", values, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledNotIn(List<String> values) {
            addCriterion("cancelled not in", values, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledBetween(String value1, String value2) {
            addCriterion("cancelled between", value1, value2, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledNotBetween(String value1, String value2) {
            addCriterion("cancelled not between", value1, value2, "cancelled");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceIsNull() {
            addCriterion("community_police is null");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceIsNotNull() {
            addCriterion("community_police is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceEqualTo(String value) {
            addCriterion("community_police =", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceNotEqualTo(String value) {
            addCriterion("community_police <>", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceGreaterThan(String value) {
            addCriterion("community_police >", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceGreaterThanOrEqualTo(String value) {
            addCriterion("community_police >=", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceLessThan(String value) {
            addCriterion("community_police <", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceLessThanOrEqualTo(String value) {
            addCriterion("community_police <=", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceLike(String value) {
            addCriterion("community_police like", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceNotLike(String value) {
            addCriterion("community_police not like", value, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceIn(List<String> values) {
            addCriterion("community_police in", values, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceNotIn(List<String> values) {
            addCriterion("community_police not in", values, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceBetween(String value1, String value2) {
            addCriterion("community_police between", value1, value2, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andCommunityPoliceNotBetween(String value1, String value2) {
            addCriterion("community_police not between", value1, value2, "communityPolice");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("end_date like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("end_date not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNull() {
            addCriterion("house_area is null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNotNull() {
            addCriterion("house_area is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaEqualTo(String value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(String value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(String value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(String value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(String value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLike(String value) {
            addCriterion("house_area like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotLike(String value) {
            addCriterion("house_area not like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIn(List<String> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<String> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(String value1, String value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(String value1, String value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseCountIsNull() {
            addCriterion("house_count is null");
            return (Criteria) this;
        }

        public Criteria andHouseCountIsNotNull() {
            addCriterion("house_count is not null");
            return (Criteria) this;
        }

        public Criteria andHouseCountEqualTo(String value) {
            addCriterion("house_count =", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountNotEqualTo(String value) {
            addCriterion("house_count <>", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountGreaterThan(String value) {
            addCriterion("house_count >", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountGreaterThanOrEqualTo(String value) {
            addCriterion("house_count >=", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountLessThan(String value) {
            addCriterion("house_count <", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountLessThanOrEqualTo(String value) {
            addCriterion("house_count <=", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountLike(String value) {
            addCriterion("house_count like", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountNotLike(String value) {
            addCriterion("house_count not like", value, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountIn(List<String> values) {
            addCriterion("house_count in", values, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountNotIn(List<String> values) {
            addCriterion("house_count not in", values, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountBetween(String value1, String value2) {
            addCriterion("house_count between", value1, value2, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHouseCountNotBetween(String value1, String value2) {
            addCriterion("house_count not between", value1, value2, "houseCount");
            return (Criteria) this;
        }

        public Criteria andHousePhotosIsNull() {
            addCriterion("house_photos is null");
            return (Criteria) this;
        }

        public Criteria andHousePhotosIsNotNull() {
            addCriterion("house_photos is not null");
            return (Criteria) this;
        }

        public Criteria andHousePhotosEqualTo(String value) {
            addCriterion("house_photos =", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosNotEqualTo(String value) {
            addCriterion("house_photos <>", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosGreaterThan(String value) {
            addCriterion("house_photos >", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosGreaterThanOrEqualTo(String value) {
            addCriterion("house_photos >=", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosLessThan(String value) {
            addCriterion("house_photos <", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosLessThanOrEqualTo(String value) {
            addCriterion("house_photos <=", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosLike(String value) {
            addCriterion("house_photos like", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosNotLike(String value) {
            addCriterion("house_photos not like", value, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosIn(List<String> values) {
            addCriterion("house_photos in", values, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosNotIn(List<String> values) {
            addCriterion("house_photos not in", values, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosBetween(String value1, String value2) {
            addCriterion("house_photos between", value1, value2, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHousePhotosNotBetween(String value1, String value2) {
            addCriterion("house_photos not between", value1, value2, "housePhotos");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIsNull() {
            addCriterion("house_source is null");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIsNotNull() {
            addCriterion("house_source is not null");
            return (Criteria) this;
        }

        public Criteria andHouseSourceEqualTo(String value) {
            addCriterion("house_source =", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceNotEqualTo(String value) {
            addCriterion("house_source <>", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceGreaterThan(String value) {
            addCriterion("house_source >", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceGreaterThanOrEqualTo(String value) {
            addCriterion("house_source >=", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceLessThan(String value) {
            addCriterion("house_source <", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceLessThanOrEqualTo(String value) {
            addCriterion("house_source <=", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceLike(String value) {
            addCriterion("house_source like", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceNotLike(String value) {
            addCriterion("house_source not like", value, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIn(List<String> values) {
            addCriterion("house_source in", values, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceNotIn(List<String> values) {
            addCriterion("house_source not in", values, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceBetween(String value1, String value2) {
            addCriterion("house_source between", value1, value2, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseSourceNotBetween(String value1, String value2) {
            addCriterion("house_source not between", value1, value2, "houseSource");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseUseIsNull() {
            addCriterion("house_use is null");
            return (Criteria) this;
        }

        public Criteria andHouseUseIsNotNull() {
            addCriterion("house_use is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUseEqualTo(String value) {
            addCriterion("house_use =", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseNotEqualTo(String value) {
            addCriterion("house_use <>", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseGreaterThan(String value) {
            addCriterion("house_use >", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseGreaterThanOrEqualTo(String value) {
            addCriterion("house_use >=", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseLessThan(String value) {
            addCriterion("house_use <", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseLessThanOrEqualTo(String value) {
            addCriterion("house_use <=", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseLike(String value) {
            addCriterion("house_use like", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseNotLike(String value) {
            addCriterion("house_use not like", value, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseIn(List<String> values) {
            addCriterion("house_use in", values, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseNotIn(List<String> values) {
            addCriterion("house_use not in", values, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseBetween(String value1, String value2) {
            addCriterion("house_use between", value1, value2, "houseUse");
            return (Criteria) this;
        }

        public Criteria andHouseUseNotBetween(String value1, String value2) {
            addCriterion("house_use not between", value1, value2, "houseUse");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNull() {
            addCriterion("pp_id is null");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNotNull() {
            addCriterion("pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpIdEqualTo(String value) {
            addCriterion("pp_id =", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotEqualTo(String value) {
            addCriterion("pp_id <>", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThan(String value) {
            addCriterion("pp_id >", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThanOrEqualTo(String value) {
            addCriterion("pp_id >=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThan(String value) {
            addCriterion("pp_id <", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThanOrEqualTo(String value) {
            addCriterion("pp_id <=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLike(String value) {
            addCriterion("pp_id like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotLike(String value) {
            addCriterion("pp_id not like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdIn(List<String> values) {
            addCriterion("pp_id in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotIn(List<String> values) {
            addCriterion("pp_id not in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdBetween(String value1, String value2) {
            addCriterion("pp_id between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotBetween(String value1, String value2) {
            addCriterion("pp_id not between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPropertyNoIsNull() {
            addCriterion("property_no is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNoIsNotNull() {
            addCriterion("property_no is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNoEqualTo(String value) {
            addCriterion("property_no =", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoNotEqualTo(String value) {
            addCriterion("property_no <>", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoGreaterThan(String value) {
            addCriterion("property_no >", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoGreaterThanOrEqualTo(String value) {
            addCriterion("property_no >=", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoLessThan(String value) {
            addCriterion("property_no <", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoLessThanOrEqualTo(String value) {
            addCriterion("property_no <=", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoLike(String value) {
            addCriterion("property_no like", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoNotLike(String value) {
            addCriterion("property_no not like", value, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoIn(List<String> values) {
            addCriterion("property_no in", values, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoNotIn(List<String> values) {
            addCriterion("property_no not in", values, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoBetween(String value1, String value2) {
            addCriterion("property_no between", value1, value2, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyNoNotBetween(String value1, String value2) {
            addCriterion("property_no not between", value1, value2, "propertyNo");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("property_type is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("property_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("property_type =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("property_type <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("property_type >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("property_type >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("property_type <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("property_type <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLike(String value) {
            addCriterion("property_type like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("property_type not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("property_type in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("property_type not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("property_type between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("property_type not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andRateTimeIsNull() {
            addCriterion("rate_time is null");
            return (Criteria) this;
        }

        public Criteria andRateTimeIsNotNull() {
            addCriterion("rate_time is not null");
            return (Criteria) this;
        }

        public Criteria andRateTimeEqualTo(String value) {
            addCriterion("rate_time =", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotEqualTo(String value) {
            addCriterion("rate_time <>", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeGreaterThan(String value) {
            addCriterion("rate_time >", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("rate_time >=", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeLessThan(String value) {
            addCriterion("rate_time <", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeLessThanOrEqualTo(String value) {
            addCriterion("rate_time <=", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeLike(String value) {
            addCriterion("rate_time like", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotLike(String value) {
            addCriterion("rate_time not like", value, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeIn(List<String> values) {
            addCriterion("rate_time in", values, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotIn(List<String> values) {
            addCriterion("rate_time not in", values, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeBetween(String value1, String value2) {
            addCriterion("rate_time between", value1, value2, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRateTimeNotBetween(String value1, String value2) {
            addCriterion("rate_time not between", value1, value2, "rateTime");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNull() {
            addCriterion("rent_status is null");
            return (Criteria) this;
        }

        public Criteria andRentStatusIsNotNull() {
            addCriterion("rent_status is not null");
            return (Criteria) this;
        }

        public Criteria andRentStatusEqualTo(String value) {
            addCriterion("rent_status =", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotEqualTo(String value) {
            addCriterion("rent_status <>", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThan(String value) {
            addCriterion("rent_status >", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("rent_status >=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThan(String value) {
            addCriterion("rent_status <", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLessThanOrEqualTo(String value) {
            addCriterion("rent_status <=", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusLike(String value) {
            addCriterion("rent_status like", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotLike(String value) {
            addCriterion("rent_status not like", value, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusIn(List<String> values) {
            addCriterion("rent_status in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotIn(List<String> values) {
            addCriterion("rent_status not in", values, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusBetween(String value1, String value2) {
            addCriterion("rent_status between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andRentStatusNotBetween(String value1, String value2) {
            addCriterion("rent_status not between", value1, value2, "rentStatus");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderIsNull() {
            addCriterion("response_leader is null");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderIsNotNull() {
            addCriterion("response_leader is not null");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderEqualTo(String value) {
            addCriterion("response_leader =", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderNotEqualTo(String value) {
            addCriterion("response_leader <>", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderGreaterThan(String value) {
            addCriterion("response_leader >", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("response_leader >=", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderLessThan(String value) {
            addCriterion("response_leader <", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderLessThanOrEqualTo(String value) {
            addCriterion("response_leader <=", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderLike(String value) {
            addCriterion("response_leader like", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderNotLike(String value) {
            addCriterion("response_leader not like", value, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderIn(List<String> values) {
            addCriterion("response_leader in", values, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderNotIn(List<String> values) {
            addCriterion("response_leader not in", values, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderBetween(String value1, String value2) {
            addCriterion("response_leader between", value1, value2, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andResponseLeaderNotBetween(String value1, String value2) {
            addCriterion("response_leader not between", value1, value2, "responseLeader");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookIsNull() {
            addCriterion("sign_response_book is null");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookIsNotNull() {
            addCriterion("sign_response_book is not null");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookEqualTo(String value) {
            addCriterion("sign_response_book =", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookNotEqualTo(String value) {
            addCriterion("sign_response_book <>", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookGreaterThan(String value) {
            addCriterion("sign_response_book >", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookGreaterThanOrEqualTo(String value) {
            addCriterion("sign_response_book >=", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookLessThan(String value) {
            addCriterion("sign_response_book <", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookLessThanOrEqualTo(String value) {
            addCriterion("sign_response_book <=", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookLike(String value) {
            addCriterion("sign_response_book like", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookNotLike(String value) {
            addCriterion("sign_response_book not like", value, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookIn(List<String> values) {
            addCriterion("sign_response_book in", values, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookNotIn(List<String> values) {
            addCriterion("sign_response_book not in", values, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookBetween(String value1, String value2) {
            addCriterion("sign_response_book between", value1, value2, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andSignResponseBookNotBetween(String value1, String value2) {
            addCriterion("sign_response_book not between", value1, value2, "signResponseBook");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(String value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(String value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(String value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(String value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(String value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(String value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLike(String value) {
            addCriterion("star like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotLike(String value) {
            addCriterion("star not like", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<String> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<String> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(String value1, String value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(String value1, String value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonIsNull() {
            addCriterion("stop_rent_reason is null");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonIsNotNull() {
            addCriterion("stop_rent_reason is not null");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonEqualTo(String value) {
            addCriterion("stop_rent_reason =", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonNotEqualTo(String value) {
            addCriterion("stop_rent_reason <>", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonGreaterThan(String value) {
            addCriterion("stop_rent_reason >", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonGreaterThanOrEqualTo(String value) {
            addCriterion("stop_rent_reason >=", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonLessThan(String value) {
            addCriterion("stop_rent_reason <", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonLessThanOrEqualTo(String value) {
            addCriterion("stop_rent_reason <=", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonLike(String value) {
            addCriterion("stop_rent_reason like", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonNotLike(String value) {
            addCriterion("stop_rent_reason not like", value, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonIn(List<String> values) {
            addCriterion("stop_rent_reason in", values, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonNotIn(List<String> values) {
            addCriterion("stop_rent_reason not in", values, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonBetween(String value1, String value2) {
            addCriterion("stop_rent_reason between", value1, value2, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andStopRentReasonNotBetween(String value1, String value2) {
            addCriterion("stop_rent_reason not between", value1, value2, "stopRentReason");
            return (Criteria) this;
        }

        public Criteria andTrustByIsNull() {
            addCriterion("trust_by is null");
            return (Criteria) this;
        }

        public Criteria andTrustByIsNotNull() {
            addCriterion("trust_by is not null");
            return (Criteria) this;
        }

        public Criteria andTrustByEqualTo(String value) {
            addCriterion("trust_by =", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByNotEqualTo(String value) {
            addCriterion("trust_by <>", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByGreaterThan(String value) {
            addCriterion("trust_by >", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByGreaterThanOrEqualTo(String value) {
            addCriterion("trust_by >=", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByLessThan(String value) {
            addCriterion("trust_by <", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByLessThanOrEqualTo(String value) {
            addCriterion("trust_by <=", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByLike(String value) {
            addCriterion("trust_by like", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByNotLike(String value) {
            addCriterion("trust_by not like", value, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByIn(List<String> values) {
            addCriterion("trust_by in", values, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByNotIn(List<String> values) {
            addCriterion("trust_by not in", values, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByBetween(String value1, String value2) {
            addCriterion("trust_by between", value1, value2, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrustByNotBetween(String value1, String value2) {
            addCriterion("trust_by not between", value1, value2, "trustBy");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressIsNull() {
            addCriterion("trustee_household_address is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressIsNotNull() {
            addCriterion("trustee_household_address is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressEqualTo(String value) {
            addCriterion("trustee_household_address =", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressNotEqualTo(String value) {
            addCriterion("trustee_household_address <>", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressGreaterThan(String value) {
            addCriterion("trustee_household_address >", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_household_address >=", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressLessThan(String value) {
            addCriterion("trustee_household_address <", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressLessThanOrEqualTo(String value) {
            addCriterion("trustee_household_address <=", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressLike(String value) {
            addCriterion("trustee_household_address like", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressNotLike(String value) {
            addCriterion("trustee_household_address not like", value, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressIn(List<String> values) {
            addCriterion("trustee_household_address in", values, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressNotIn(List<String> values) {
            addCriterion("trustee_household_address not in", values, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressBetween(String value1, String value2) {
            addCriterion("trustee_household_address between", value1, value2, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeHouseholdAddressNotBetween(String value1, String value2) {
            addCriterion("trustee_household_address not between", value1, value2, "trusteeHouseholdAddress");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIsNull() {
            addCriterion("trustee_name is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIsNotNull() {
            addCriterion("trustee_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameEqualTo(String value) {
            addCriterion("trustee_name =", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotEqualTo(String value) {
            addCriterion("trustee_name <>", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameGreaterThan(String value) {
            addCriterion("trustee_name >", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_name >=", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLessThan(String value) {
            addCriterion("trustee_name <", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLessThanOrEqualTo(String value) {
            addCriterion("trustee_name <=", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLike(String value) {
            addCriterion("trustee_name like", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotLike(String value) {
            addCriterion("trustee_name not like", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIn(List<String> values) {
            addCriterion("trustee_name in", values, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotIn(List<String> values) {
            addCriterion("trustee_name not in", values, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameBetween(String value1, String value2) {
            addCriterion("trustee_name between", value1, value2, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotBetween(String value1, String value2) {
            addCriterion("trustee_name not between", value1, value2, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationIsNull() {
            addCriterion("trustee_nation is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationIsNotNull() {
            addCriterion("trustee_nation is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationEqualTo(String value) {
            addCriterion("trustee_nation =", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationNotEqualTo(String value) {
            addCriterion("trustee_nation <>", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationGreaterThan(String value) {
            addCriterion("trustee_nation >", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_nation >=", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationLessThan(String value) {
            addCriterion("trustee_nation <", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationLessThanOrEqualTo(String value) {
            addCriterion("trustee_nation <=", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationLike(String value) {
            addCriterion("trustee_nation like", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationNotLike(String value) {
            addCriterion("trustee_nation not like", value, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationIn(List<String> values) {
            addCriterion("trustee_nation in", values, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationNotIn(List<String> values) {
            addCriterion("trustee_nation not in", values, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationBetween(String value1, String value2) {
            addCriterion("trustee_nation between", value1, value2, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteeNationNotBetween(String value1, String value2) {
            addCriterion("trustee_nation not between", value1, value2, "trusteeNation");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdIsNull() {
            addCriterion("trustee_pp_id is null");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdIsNotNull() {
            addCriterion("trustee_pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdEqualTo(String value) {
            addCriterion("trustee_pp_id =", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdNotEqualTo(String value) {
            addCriterion("trustee_pp_id <>", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdGreaterThan(String value) {
            addCriterion("trustee_pp_id >", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_pp_id >=", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdLessThan(String value) {
            addCriterion("trustee_pp_id <", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdLessThanOrEqualTo(String value) {
            addCriterion("trustee_pp_id <=", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdLike(String value) {
            addCriterion("trustee_pp_id like", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdNotLike(String value) {
            addCriterion("trustee_pp_id not like", value, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdIn(List<String> values) {
            addCriterion("trustee_pp_id in", values, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdNotIn(List<String> values) {
            addCriterion("trustee_pp_id not in", values, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdBetween(String value1, String value2) {
            addCriterion("trustee_pp_id between", value1, value2, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteePpIdNotBetween(String value1, String value2) {
            addCriterion("trustee_pp_id not between", value1, value2, "trusteePpId");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationIsNull() {
            addCriterion("trustee_relation is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationIsNotNull() {
            addCriterion("trustee_relation is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationEqualTo(String value) {
            addCriterion("trustee_relation =", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationNotEqualTo(String value) {
            addCriterion("trustee_relation <>", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationGreaterThan(String value) {
            addCriterion("trustee_relation >", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_relation >=", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationLessThan(String value) {
            addCriterion("trustee_relation <", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationLessThanOrEqualTo(String value) {
            addCriterion("trustee_relation <=", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationLike(String value) {
            addCriterion("trustee_relation like", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationNotLike(String value) {
            addCriterion("trustee_relation not like", value, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationIn(List<String> values) {
            addCriterion("trustee_relation in", values, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationNotIn(List<String> values) {
            addCriterion("trustee_relation not in", values, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationBetween(String value1, String value2) {
            addCriterion("trustee_relation between", value1, value2, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeRelationNotBetween(String value1, String value2) {
            addCriterion("trustee_relation not between", value1, value2, "trusteeRelation");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelIsNull() {
            addCriterion("trustee_tel is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelIsNotNull() {
            addCriterion("trustee_tel is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelEqualTo(String value) {
            addCriterion("trustee_tel =", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelNotEqualTo(String value) {
            addCriterion("trustee_tel <>", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelGreaterThan(String value) {
            addCriterion("trustee_tel >", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_tel >=", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelLessThan(String value) {
            addCriterion("trustee_tel <", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelLessThanOrEqualTo(String value) {
            addCriterion("trustee_tel <=", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelLike(String value) {
            addCriterion("trustee_tel like", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelNotLike(String value) {
            addCriterion("trustee_tel not like", value, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelIn(List<String> values) {
            addCriterion("trustee_tel in", values, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelNotIn(List<String> values) {
            addCriterion("trustee_tel not in", values, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelBetween(String value1, String value2) {
            addCriterion("trustee_tel between", value1, value2, "trusteeTel");
            return (Criteria) this;
        }

        public Criteria andTrusteeTelNotBetween(String value1, String value2) {
            addCriterion("trustee_tel not between", value1, value2, "trusteeTel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}