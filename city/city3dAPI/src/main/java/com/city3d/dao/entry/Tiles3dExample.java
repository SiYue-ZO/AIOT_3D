package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class Tiles3dExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tiles3dExample() {
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

        public Criteria andTilesIdIsNull() {
            addCriterion("tiles_id is null");
            return (Criteria) this;
        }

        public Criteria andTilesIdIsNotNull() {
            addCriterion("tiles_id is not null");
            return (Criteria) this;
        }

        public Criteria andTilesIdEqualTo(String value) {
            addCriterion("tiles_id =", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotEqualTo(String value) {
            addCriterion("tiles_id <>", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdGreaterThan(String value) {
            addCriterion("tiles_id >", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_id >=", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLessThan(String value) {
            addCriterion("tiles_id <", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLessThanOrEqualTo(String value) {
            addCriterion("tiles_id <=", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdLike(String value) {
            addCriterion("tiles_id like", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotLike(String value) {
            addCriterion("tiles_id not like", value, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdIn(List<String> values) {
            addCriterion("tiles_id in", values, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotIn(List<String> values) {
            addCriterion("tiles_id not in", values, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdBetween(String value1, String value2) {
            addCriterion("tiles_id between", value1, value2, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesIdNotBetween(String value1, String value2) {
            addCriterion("tiles_id not between", value1, value2, "tilesId");
            return (Criteria) this;
        }

        public Criteria andTilesNameIsNull() {
            addCriterion("tiles_name is null");
            return (Criteria) this;
        }

        public Criteria andTilesNameIsNotNull() {
            addCriterion("tiles_name is not null");
            return (Criteria) this;
        }

        public Criteria andTilesNameEqualTo(String value) {
            addCriterion("tiles_name =", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameNotEqualTo(String value) {
            addCriterion("tiles_name <>", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameGreaterThan(String value) {
            addCriterion("tiles_name >", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_name >=", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameLessThan(String value) {
            addCriterion("tiles_name <", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameLessThanOrEqualTo(String value) {
            addCriterion("tiles_name <=", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameLike(String value) {
            addCriterion("tiles_name like", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameNotLike(String value) {
            addCriterion("tiles_name not like", value, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameIn(List<String> values) {
            addCriterion("tiles_name in", values, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameNotIn(List<String> values) {
            addCriterion("tiles_name not in", values, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameBetween(String value1, String value2) {
            addCriterion("tiles_name between", value1, value2, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesNameNotBetween(String value1, String value2) {
            addCriterion("tiles_name not between", value1, value2, "tilesName");
            return (Criteria) this;
        }

        public Criteria andTilesUrlIsNull() {
            addCriterion("tiles_url is null");
            return (Criteria) this;
        }

        public Criteria andTilesUrlIsNotNull() {
            addCriterion("tiles_url is not null");
            return (Criteria) this;
        }

        public Criteria andTilesUrlEqualTo(String value) {
            addCriterion("tiles_url =", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlNotEqualTo(String value) {
            addCriterion("tiles_url <>", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlGreaterThan(String value) {
            addCriterion("tiles_url >", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_url >=", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlLessThan(String value) {
            addCriterion("tiles_url <", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlLessThanOrEqualTo(String value) {
            addCriterion("tiles_url <=", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlLike(String value) {
            addCriterion("tiles_url like", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlNotLike(String value) {
            addCriterion("tiles_url not like", value, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlIn(List<String> values) {
            addCriterion("tiles_url in", values, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlNotIn(List<String> values) {
            addCriterion("tiles_url not in", values, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlBetween(String value1, String value2) {
            addCriterion("tiles_url between", value1, value2, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesUrlNotBetween(String value1, String value2) {
            addCriterion("tiles_url not between", value1, value2, "tilesUrl");
            return (Criteria) this;
        }

        public Criteria andTilesTypeIsNull() {
            addCriterion("tiles_type is null");
            return (Criteria) this;
        }

        public Criteria andTilesTypeIsNotNull() {
            addCriterion("tiles_type is not null");
            return (Criteria) this;
        }

        public Criteria andTilesTypeEqualTo(String value) {
            addCriterion("tiles_type =", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeNotEqualTo(String value) {
            addCriterion("tiles_type <>", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeGreaterThan(String value) {
            addCriterion("tiles_type >", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_type >=", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeLessThan(String value) {
            addCriterion("tiles_type <", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeLessThanOrEqualTo(String value) {
            addCriterion("tiles_type <=", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeLike(String value) {
            addCriterion("tiles_type like", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeNotLike(String value) {
            addCriterion("tiles_type not like", value, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeIn(List<String> values) {
            addCriterion("tiles_type in", values, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeNotIn(List<String> values) {
            addCriterion("tiles_type not in", values, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeBetween(String value1, String value2) {
            addCriterion("tiles_type between", value1, value2, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesTypeNotBetween(String value1, String value2) {
            addCriterion("tiles_type not between", value1, value2, "tilesType");
            return (Criteria) this;
        }

        public Criteria andTilesXIsNull() {
            addCriterion("tiles_x is null");
            return (Criteria) this;
        }

        public Criteria andTilesXIsNotNull() {
            addCriterion("tiles_x is not null");
            return (Criteria) this;
        }

        public Criteria andTilesXEqualTo(String value) {
            addCriterion("tiles_x =", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXNotEqualTo(String value) {
            addCriterion("tiles_x <>", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXGreaterThan(String value) {
            addCriterion("tiles_x >", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_x >=", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXLessThan(String value) {
            addCriterion("tiles_x <", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXLessThanOrEqualTo(String value) {
            addCriterion("tiles_x <=", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXLike(String value) {
            addCriterion("tiles_x like", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXNotLike(String value) {
            addCriterion("tiles_x not like", value, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXIn(List<String> values) {
            addCriterion("tiles_x in", values, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXNotIn(List<String> values) {
            addCriterion("tiles_x not in", values, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXBetween(String value1, String value2) {
            addCriterion("tiles_x between", value1, value2, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesXNotBetween(String value1, String value2) {
            addCriterion("tiles_x not between", value1, value2, "tilesX");
            return (Criteria) this;
        }

        public Criteria andTilesYIsNull() {
            addCriterion("tiles_y is null");
            return (Criteria) this;
        }

        public Criteria andTilesYIsNotNull() {
            addCriterion("tiles_y is not null");
            return (Criteria) this;
        }

        public Criteria andTilesYEqualTo(String value) {
            addCriterion("tiles_y =", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYNotEqualTo(String value) {
            addCriterion("tiles_y <>", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYGreaterThan(String value) {
            addCriterion("tiles_y >", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_y >=", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYLessThan(String value) {
            addCriterion("tiles_y <", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYLessThanOrEqualTo(String value) {
            addCriterion("tiles_y <=", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYLike(String value) {
            addCriterion("tiles_y like", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYNotLike(String value) {
            addCriterion("tiles_y not like", value, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYIn(List<String> values) {
            addCriterion("tiles_y in", values, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYNotIn(List<String> values) {
            addCriterion("tiles_y not in", values, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYBetween(String value1, String value2) {
            addCriterion("tiles_y between", value1, value2, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesYNotBetween(String value1, String value2) {
            addCriterion("tiles_y not between", value1, value2, "tilesY");
            return (Criteria) this;
        }

        public Criteria andTilesZIsNull() {
            addCriterion("tiles_z is null");
            return (Criteria) this;
        }

        public Criteria andTilesZIsNotNull() {
            addCriterion("tiles_z is not null");
            return (Criteria) this;
        }

        public Criteria andTilesZEqualTo(String value) {
            addCriterion("tiles_z =", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZNotEqualTo(String value) {
            addCriterion("tiles_z <>", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZGreaterThan(String value) {
            addCriterion("tiles_z >", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_z >=", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZLessThan(String value) {
            addCriterion("tiles_z <", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZLessThanOrEqualTo(String value) {
            addCriterion("tiles_z <=", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZLike(String value) {
            addCriterion("tiles_z like", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZNotLike(String value) {
            addCriterion("tiles_z not like", value, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZIn(List<String> values) {
            addCriterion("tiles_z in", values, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZNotIn(List<String> values) {
            addCriterion("tiles_z not in", values, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZBetween(String value1, String value2) {
            addCriterion("tiles_z between", value1, value2, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andTilesZNotBetween(String value1, String value2) {
            addCriterion("tiles_z not between", value1, value2, "tilesZ");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNull() {
            addCriterion("cam_poi is null");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNotNull() {
            addCriterion("cam_poi is not null");
            return (Criteria) this;
        }

        public Criteria andCamPoiEqualTo(String value) {
            addCriterion("cam_poi =", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotEqualTo(String value) {
            addCriterion("cam_poi <>", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThan(String value) {
            addCriterion("cam_poi >", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThanOrEqualTo(String value) {
            addCriterion("cam_poi >=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThan(String value) {
            addCriterion("cam_poi <", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThanOrEqualTo(String value) {
            addCriterion("cam_poi <=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLike(String value) {
            addCriterion("cam_poi like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotLike(String value) {
            addCriterion("cam_poi not like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIn(List<String> values) {
            addCriterion("cam_poi in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotIn(List<String> values) {
            addCriterion("cam_poi not in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiBetween(String value1, String value2) {
            addCriterion("cam_poi between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotBetween(String value1, String value2) {
            addCriterion("cam_poi not between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNull() {
            addCriterion("cam_heading is null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNotNull() {
            addCriterion("cam_heading is not null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingEqualTo(String value) {
            addCriterion("cam_heading =", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotEqualTo(String value) {
            addCriterion("cam_heading <>", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThan(String value) {
            addCriterion("cam_heading >", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("cam_heading >=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThan(String value) {
            addCriterion("cam_heading <", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThanOrEqualTo(String value) {
            addCriterion("cam_heading <=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLike(String value) {
            addCriterion("cam_heading like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotLike(String value) {
            addCriterion("cam_heading not like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIn(List<String> values) {
            addCriterion("cam_heading in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotIn(List<String> values) {
            addCriterion("cam_heading not in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingBetween(String value1, String value2) {
            addCriterion("cam_heading between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotBetween(String value1, String value2) {
            addCriterion("cam_heading not between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNull() {
            addCriterion("cam_pitch is null");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNotNull() {
            addCriterion("cam_pitch is not null");
            return (Criteria) this;
        }

        public Criteria andCamPitchEqualTo(String value) {
            addCriterion("cam_pitch =", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotEqualTo(String value) {
            addCriterion("cam_pitch <>", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThan(String value) {
            addCriterion("cam_pitch >", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pitch >=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThan(String value) {
            addCriterion("cam_pitch <", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThanOrEqualTo(String value) {
            addCriterion("cam_pitch <=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLike(String value) {
            addCriterion("cam_pitch like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotLike(String value) {
            addCriterion("cam_pitch not like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchIn(List<String> values) {
            addCriterion("cam_pitch in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotIn(List<String> values) {
            addCriterion("cam_pitch not in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchBetween(String value1, String value2) {
            addCriterion("cam_pitch between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotBetween(String value1, String value2) {
            addCriterion("cam_pitch not between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentIsNull() {
            addCriterion("tiles_transparent is null");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentIsNotNull() {
            addCriterion("tiles_transparent is not null");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentEqualTo(String value) {
            addCriterion("tiles_transparent =", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentNotEqualTo(String value) {
            addCriterion("tiles_transparent <>", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentGreaterThan(String value) {
            addCriterion("tiles_transparent >", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentGreaterThanOrEqualTo(String value) {
            addCriterion("tiles_transparent >=", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentLessThan(String value) {
            addCriterion("tiles_transparent <", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentLessThanOrEqualTo(String value) {
            addCriterion("tiles_transparent <=", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentLike(String value) {
            addCriterion("tiles_transparent like", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentNotLike(String value) {
            addCriterion("tiles_transparent not like", value, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentIn(List<String> values) {
            addCriterion("tiles_transparent in", values, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentNotIn(List<String> values) {
            addCriterion("tiles_transparent not in", values, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentBetween(String value1, String value2) {
            addCriterion("tiles_transparent between", value1, value2, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andTilesTransparentNotBetween(String value1, String value2) {
            addCriterion("tiles_transparent not between", value1, value2, "tilesTransparent");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesIsNull() {
            addCriterion("max_num_loaded_tiles is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesIsNotNull() {
            addCriterion("max_num_loaded_tiles is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesEqualTo(String value) {
            addCriterion("max_num_loaded_tiles =", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesNotEqualTo(String value) {
            addCriterion("max_num_loaded_tiles <>", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesGreaterThan(String value) {
            addCriterion("max_num_loaded_tiles >", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesGreaterThanOrEqualTo(String value) {
            addCriterion("max_num_loaded_tiles >=", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesLessThan(String value) {
            addCriterion("max_num_loaded_tiles <", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesLessThanOrEqualTo(String value) {
            addCriterion("max_num_loaded_tiles <=", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesLike(String value) {
            addCriterion("max_num_loaded_tiles like", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesNotLike(String value) {
            addCriterion("max_num_loaded_tiles not like", value, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesIn(List<String> values) {
            addCriterion("max_num_loaded_tiles in", values, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesNotIn(List<String> values) {
            addCriterion("max_num_loaded_tiles not in", values, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesBetween(String value1, String value2) {
            addCriterion("max_num_loaded_tiles between", value1, value2, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxNumLoadedTilesNotBetween(String value1, String value2) {
            addCriterion("max_num_loaded_tiles not between", value1, value2, "maxNumLoadedTiles");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageIsNull() {
            addCriterion("max_memory_usage is null");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageIsNotNull() {
            addCriterion("max_memory_usage is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageEqualTo(String value) {
            addCriterion("max_memory_usage =", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageNotEqualTo(String value) {
            addCriterion("max_memory_usage <>", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageGreaterThan(String value) {
            addCriterion("max_memory_usage >", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageGreaterThanOrEqualTo(String value) {
            addCriterion("max_memory_usage >=", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageLessThan(String value) {
            addCriterion("max_memory_usage <", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageLessThanOrEqualTo(String value) {
            addCriterion("max_memory_usage <=", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageLike(String value) {
            addCriterion("max_memory_usage like", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageNotLike(String value) {
            addCriterion("max_memory_usage not like", value, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageIn(List<String> values) {
            addCriterion("max_memory_usage in", values, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageNotIn(List<String> values) {
            addCriterion("max_memory_usage not in", values, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageBetween(String value1, String value2) {
            addCriterion("max_memory_usage between", value1, value2, "maxMemoryUsage");
            return (Criteria) this;
        }

        public Criteria andMaxMemoryUsageNotBetween(String value1, String value2) {
            addCriterion("max_memory_usage not between", value1, value2, "maxMemoryUsage");
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