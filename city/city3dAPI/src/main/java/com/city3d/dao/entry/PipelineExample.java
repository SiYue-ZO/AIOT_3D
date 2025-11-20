package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PipelineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PipelineExample() {
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

        public Criteria andPipeIdIsNull() {
            addCriterion("pipe_id is null");
            return (Criteria) this;
        }

        public Criteria andPipeIdIsNotNull() {
            addCriterion("pipe_id is not null");
            return (Criteria) this;
        }

        public Criteria andPipeIdEqualTo(String value) {
            addCriterion("pipe_id =", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdNotEqualTo(String value) {
            addCriterion("pipe_id <>", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdGreaterThan(String value) {
            addCriterion("pipe_id >", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdGreaterThanOrEqualTo(String value) {
            addCriterion("pipe_id >=", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdLessThan(String value) {
            addCriterion("pipe_id <", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdLessThanOrEqualTo(String value) {
            addCriterion("pipe_id <=", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdLike(String value) {
            addCriterion("pipe_id like", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdNotLike(String value) {
            addCriterion("pipe_id not like", value, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdIn(List<String> values) {
            addCriterion("pipe_id in", values, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdNotIn(List<String> values) {
            addCriterion("pipe_id not in", values, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdBetween(String value1, String value2) {
            addCriterion("pipe_id between", value1, value2, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPipeIdNotBetween(String value1, String value2) {
            addCriterion("pipe_id not between", value1, value2, "pipeId");
            return (Criteria) this;
        }

        public Criteria andPlNameIsNull() {
            addCriterion("pl_name is null");
            return (Criteria) this;
        }

        public Criteria andPlNameIsNotNull() {
            addCriterion("pl_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlNameEqualTo(String value) {
            addCriterion("pl_name =", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameNotEqualTo(String value) {
            addCriterion("pl_name <>", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameGreaterThan(String value) {
            addCriterion("pl_name >", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameGreaterThanOrEqualTo(String value) {
            addCriterion("pl_name >=", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameLessThan(String value) {
            addCriterion("pl_name <", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameLessThanOrEqualTo(String value) {
            addCriterion("pl_name <=", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameLike(String value) {
            addCriterion("pl_name like", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameNotLike(String value) {
            addCriterion("pl_name not like", value, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameIn(List<String> values) {
            addCriterion("pl_name in", values, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameNotIn(List<String> values) {
            addCriterion("pl_name not in", values, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameBetween(String value1, String value2) {
            addCriterion("pl_name between", value1, value2, "plName");
            return (Criteria) this;
        }

        public Criteria andPlNameNotBetween(String value1, String value2) {
            addCriterion("pl_name not between", value1, value2, "plName");
            return (Criteria) this;
        }

        public Criteria andPlLineIsNull() {
            addCriterion("pl_line is null");
            return (Criteria) this;
        }

        public Criteria andPlLineIsNotNull() {
            addCriterion("pl_line is not null");
            return (Criteria) this;
        }

        public Criteria andPlLineEqualTo(String value) {
            addCriterion("pl_line =", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineNotEqualTo(String value) {
            addCriterion("pl_line <>", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineGreaterThan(String value) {
            addCriterion("pl_line >", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineGreaterThanOrEqualTo(String value) {
            addCriterion("pl_line >=", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineLessThan(String value) {
            addCriterion("pl_line <", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineLessThanOrEqualTo(String value) {
            addCriterion("pl_line <=", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineLike(String value) {
            addCriterion("pl_line like", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineNotLike(String value) {
            addCriterion("pl_line not like", value, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineIn(List<String> values) {
            addCriterion("pl_line in", values, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineNotIn(List<String> values) {
            addCriterion("pl_line not in", values, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineBetween(String value1, String value2) {
            addCriterion("pl_line between", value1, value2, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlLineNotBetween(String value1, String value2) {
            addCriterion("pl_line not between", value1, value2, "plLine");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterIsNull() {
            addCriterion("pl_out_diameter is null");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterIsNotNull() {
            addCriterion("pl_out_diameter is not null");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterEqualTo(String value) {
            addCriterion("pl_out_diameter =", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterNotEqualTo(String value) {
            addCriterion("pl_out_diameter <>", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterGreaterThan(String value) {
            addCriterion("pl_out_diameter >", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterGreaterThanOrEqualTo(String value) {
            addCriterion("pl_out_diameter >=", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterLessThan(String value) {
            addCriterion("pl_out_diameter <", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterLessThanOrEqualTo(String value) {
            addCriterion("pl_out_diameter <=", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterLike(String value) {
            addCriterion("pl_out_diameter like", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterNotLike(String value) {
            addCriterion("pl_out_diameter not like", value, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterIn(List<String> values) {
            addCriterion("pl_out_diameter in", values, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterNotIn(List<String> values) {
            addCriterion("pl_out_diameter not in", values, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterBetween(String value1, String value2) {
            addCriterion("pl_out_diameter between", value1, value2, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlOutDiameterNotBetween(String value1, String value2) {
            addCriterion("pl_out_diameter not between", value1, value2, "plOutDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterIsNull() {
            addCriterion("pl_in_diameter is null");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterIsNotNull() {
            addCriterion("pl_in_diameter is not null");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterEqualTo(String value) {
            addCriterion("pl_in_diameter =", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterNotEqualTo(String value) {
            addCriterion("pl_in_diameter <>", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterGreaterThan(String value) {
            addCriterion("pl_in_diameter >", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterGreaterThanOrEqualTo(String value) {
            addCriterion("pl_in_diameter >=", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterLessThan(String value) {
            addCriterion("pl_in_diameter <", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterLessThanOrEqualTo(String value) {
            addCriterion("pl_in_diameter <=", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterLike(String value) {
            addCriterion("pl_in_diameter like", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterNotLike(String value) {
            addCriterion("pl_in_diameter not like", value, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterIn(List<String> values) {
            addCriterion("pl_in_diameter in", values, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterNotIn(List<String> values) {
            addCriterion("pl_in_diameter not in", values, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterBetween(String value1, String value2) {
            addCriterion("pl_in_diameter between", value1, value2, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlInDiameterNotBetween(String value1, String value2) {
            addCriterion("pl_in_diameter not between", value1, value2, "plInDiameter");
            return (Criteria) this;
        }

        public Criteria andPlDeepIsNull() {
            addCriterion("pl_deep is null");
            return (Criteria) this;
        }

        public Criteria andPlDeepIsNotNull() {
            addCriterion("pl_deep is not null");
            return (Criteria) this;
        }

        public Criteria andPlDeepEqualTo(String value) {
            addCriterion("pl_deep =", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepNotEqualTo(String value) {
            addCriterion("pl_deep <>", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepGreaterThan(String value) {
            addCriterion("pl_deep >", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepGreaterThanOrEqualTo(String value) {
            addCriterion("pl_deep >=", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepLessThan(String value) {
            addCriterion("pl_deep <", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepLessThanOrEqualTo(String value) {
            addCriterion("pl_deep <=", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepLike(String value) {
            addCriterion("pl_deep like", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepNotLike(String value) {
            addCriterion("pl_deep not like", value, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepIn(List<String> values) {
            addCriterion("pl_deep in", values, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepNotIn(List<String> values) {
            addCriterion("pl_deep not in", values, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepBetween(String value1, String value2) {
            addCriterion("pl_deep between", value1, value2, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlDeepNotBetween(String value1, String value2) {
            addCriterion("pl_deep not between", value1, value2, "plDeep");
            return (Criteria) this;
        }

        public Criteria andPlMaterialIsNull() {
            addCriterion("pl_material is null");
            return (Criteria) this;
        }

        public Criteria andPlMaterialIsNotNull() {
            addCriterion("pl_material is not null");
            return (Criteria) this;
        }

        public Criteria andPlMaterialEqualTo(String value) {
            addCriterion("pl_material =", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialNotEqualTo(String value) {
            addCriterion("pl_material <>", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialGreaterThan(String value) {
            addCriterion("pl_material >", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("pl_material >=", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialLessThan(String value) {
            addCriterion("pl_material <", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialLessThanOrEqualTo(String value) {
            addCriterion("pl_material <=", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialLike(String value) {
            addCriterion("pl_material like", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialNotLike(String value) {
            addCriterion("pl_material not like", value, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialIn(List<String> values) {
            addCriterion("pl_material in", values, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialNotIn(List<String> values) {
            addCriterion("pl_material not in", values, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialBetween(String value1, String value2) {
            addCriterion("pl_material between", value1, value2, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlMaterialNotBetween(String value1, String value2) {
            addCriterion("pl_material not between", value1, value2, "plMaterial");
            return (Criteria) this;
        }

        public Criteria andPlTypeIsNull() {
            addCriterion("pl_type is null");
            return (Criteria) this;
        }

        public Criteria andPlTypeIsNotNull() {
            addCriterion("pl_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlTypeEqualTo(String value) {
            addCriterion("pl_type =", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeNotEqualTo(String value) {
            addCriterion("pl_type <>", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeGreaterThan(String value) {
            addCriterion("pl_type >", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_type >=", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeLessThan(String value) {
            addCriterion("pl_type <", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeLessThanOrEqualTo(String value) {
            addCriterion("pl_type <=", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeLike(String value) {
            addCriterion("pl_type like", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeNotLike(String value) {
            addCriterion("pl_type not like", value, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeIn(List<String> values) {
            addCriterion("pl_type in", values, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeNotIn(List<String> values) {
            addCriterion("pl_type not in", values, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeBetween(String value1, String value2) {
            addCriterion("pl_type between", value1, value2, "plType");
            return (Criteria) this;
        }

        public Criteria andPlTypeNotBetween(String value1, String value2) {
            addCriterion("pl_type not between", value1, value2, "plType");
            return (Criteria) this;
        }

        public Criteria andPlSlopeIsNull() {
            addCriterion("pl_slope is null");
            return (Criteria) this;
        }

        public Criteria andPlSlopeIsNotNull() {
            addCriterion("pl_slope is not null");
            return (Criteria) this;
        }

        public Criteria andPlSlopeEqualTo(String value) {
            addCriterion("pl_slope =", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeNotEqualTo(String value) {
            addCriterion("pl_slope <>", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeGreaterThan(String value) {
            addCriterion("pl_slope >", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_slope >=", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeLessThan(String value) {
            addCriterion("pl_slope <", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeLessThanOrEqualTo(String value) {
            addCriterion("pl_slope <=", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeLike(String value) {
            addCriterion("pl_slope like", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeNotLike(String value) {
            addCriterion("pl_slope not like", value, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeIn(List<String> values) {
            addCriterion("pl_slope in", values, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeNotIn(List<String> values) {
            addCriterion("pl_slope not in", values, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeBetween(String value1, String value2) {
            addCriterion("pl_slope between", value1, value2, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlSlopeNotBetween(String value1, String value2) {
            addCriterion("pl_slope not between", value1, value2, "plSlope");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessIsNull() {
            addCriterion("pl_roughness is null");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessIsNotNull() {
            addCriterion("pl_roughness is not null");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessEqualTo(String value) {
            addCriterion("pl_roughness =", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessNotEqualTo(String value) {
            addCriterion("pl_roughness <>", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessGreaterThan(String value) {
            addCriterion("pl_roughness >", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessGreaterThanOrEqualTo(String value) {
            addCriterion("pl_roughness >=", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessLessThan(String value) {
            addCriterion("pl_roughness <", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessLessThanOrEqualTo(String value) {
            addCriterion("pl_roughness <=", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessLike(String value) {
            addCriterion("pl_roughness like", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessNotLike(String value) {
            addCriterion("pl_roughness not like", value, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessIn(List<String> values) {
            addCriterion("pl_roughness in", values, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessNotIn(List<String> values) {
            addCriterion("pl_roughness not in", values, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessBetween(String value1, String value2) {
            addCriterion("pl_roughness between", value1, value2, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlRoughnessNotBetween(String value1, String value2) {
            addCriterion("pl_roughness not between", value1, value2, "plRoughness");
            return (Criteria) this;
        }

        public Criteria andPlDirectionIsNull() {
            addCriterion("pl_direction is null");
            return (Criteria) this;
        }

        public Criteria andPlDirectionIsNotNull() {
            addCriterion("pl_direction is not null");
            return (Criteria) this;
        }

        public Criteria andPlDirectionEqualTo(String value) {
            addCriterion("pl_direction =", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionNotEqualTo(String value) {
            addCriterion("pl_direction <>", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionGreaterThan(String value) {
            addCriterion("pl_direction >", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("pl_direction >=", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionLessThan(String value) {
            addCriterion("pl_direction <", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionLessThanOrEqualTo(String value) {
            addCriterion("pl_direction <=", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionLike(String value) {
            addCriterion("pl_direction like", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionNotLike(String value) {
            addCriterion("pl_direction not like", value, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionIn(List<String> values) {
            addCriterion("pl_direction in", values, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionNotIn(List<String> values) {
            addCriterion("pl_direction not in", values, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionBetween(String value1, String value2) {
            addCriterion("pl_direction between", value1, value2, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlDirectionNotBetween(String value1, String value2) {
            addCriterion("pl_direction not between", value1, value2, "plDirection");
            return (Criteria) this;
        }

        public Criteria andPlPosIsNull() {
            addCriterion("pl_pos is null");
            return (Criteria) this;
        }

        public Criteria andPlPosIsNotNull() {
            addCriterion("pl_pos is not null");
            return (Criteria) this;
        }

        public Criteria andPlPosEqualTo(String value) {
            addCriterion("pl_pos =", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosNotEqualTo(String value) {
            addCriterion("pl_pos <>", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosGreaterThan(String value) {
            addCriterion("pl_pos >", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosGreaterThanOrEqualTo(String value) {
            addCriterion("pl_pos >=", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosLessThan(String value) {
            addCriterion("pl_pos <", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosLessThanOrEqualTo(String value) {
            addCriterion("pl_pos <=", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosLike(String value) {
            addCriterion("pl_pos like", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosNotLike(String value) {
            addCriterion("pl_pos not like", value, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosIn(List<String> values) {
            addCriterion("pl_pos in", values, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosNotIn(List<String> values) {
            addCriterion("pl_pos not in", values, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosBetween(String value1, String value2) {
            addCriterion("pl_pos between", value1, value2, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlPosNotBetween(String value1, String value2) {
            addCriterion("pl_pos not between", value1, value2, "plPos");
            return (Criteria) this;
        }

        public Criteria andPlSortIsNull() {
            addCriterion("pl_sort is null");
            return (Criteria) this;
        }

        public Criteria andPlSortIsNotNull() {
            addCriterion("pl_sort is not null");
            return (Criteria) this;
        }

        public Criteria andPlSortEqualTo(String value) {
            addCriterion("pl_sort =", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortNotEqualTo(String value) {
            addCriterion("pl_sort <>", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortGreaterThan(String value) {
            addCriterion("pl_sort >", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortGreaterThanOrEqualTo(String value) {
            addCriterion("pl_sort >=", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortLessThan(String value) {
            addCriterion("pl_sort <", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortLessThanOrEqualTo(String value) {
            addCriterion("pl_sort <=", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortLike(String value) {
            addCriterion("pl_sort like", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortNotLike(String value) {
            addCriterion("pl_sort not like", value, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortIn(List<String> values) {
            addCriterion("pl_sort in", values, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortNotIn(List<String> values) {
            addCriterion("pl_sort not in", values, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortBetween(String value1, String value2) {
            addCriterion("pl_sort between", value1, value2, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlSortNotBetween(String value1, String value2) {
            addCriterion("pl_sort not between", value1, value2, "plSort");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopIsNull() {
            addCriterion("pl_deep_stop is null");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopIsNotNull() {
            addCriterion("pl_deep_stop is not null");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopEqualTo(String value) {
            addCriterion("pl_deep_stop =", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopNotEqualTo(String value) {
            addCriterion("pl_deep_stop <>", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopGreaterThan(String value) {
            addCriterion("pl_deep_stop >", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopGreaterThanOrEqualTo(String value) {
            addCriterion("pl_deep_stop >=", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopLessThan(String value) {
            addCriterion("pl_deep_stop <", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopLessThanOrEqualTo(String value) {
            addCriterion("pl_deep_stop <=", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopLike(String value) {
            addCriterion("pl_deep_stop like", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopNotLike(String value) {
            addCriterion("pl_deep_stop not like", value, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopIn(List<String> values) {
            addCriterion("pl_deep_stop in", values, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopNotIn(List<String> values) {
            addCriterion("pl_deep_stop not in", values, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopBetween(String value1, String value2) {
            addCriterion("pl_deep_stop between", value1, value2, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlDeepStopNotBetween(String value1, String value2) {
            addCriterion("pl_deep_stop not between", value1, value2, "plDeepStop");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeIsNull() {
            addCriterion("pl_building_type is null");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeIsNotNull() {
            addCriterion("pl_building_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeEqualTo(String value) {
            addCriterion("pl_building_type =", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeNotEqualTo(String value) {
            addCriterion("pl_building_type <>", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeGreaterThan(String value) {
            addCriterion("pl_building_type >", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_building_type >=", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeLessThan(String value) {
            addCriterion("pl_building_type <", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeLessThanOrEqualTo(String value) {
            addCriterion("pl_building_type <=", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeLike(String value) {
            addCriterion("pl_building_type like", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeNotLike(String value) {
            addCriterion("pl_building_type not like", value, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeIn(List<String> values) {
            addCriterion("pl_building_type in", values, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeNotIn(List<String> values) {
            addCriterion("pl_building_type not in", values, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeBetween(String value1, String value2) {
            addCriterion("pl_building_type between", value1, value2, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlBuildingTypeNotBetween(String value1, String value2) {
            addCriterion("pl_building_type not between", value1, value2, "plBuildingType");
            return (Criteria) this;
        }

        public Criteria andPlCarryIsNull() {
            addCriterion("pl_carry is null");
            return (Criteria) this;
        }

        public Criteria andPlCarryIsNotNull() {
            addCriterion("pl_carry is not null");
            return (Criteria) this;
        }

        public Criteria andPlCarryEqualTo(String value) {
            addCriterion("pl_carry =", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryNotEqualTo(String value) {
            addCriterion("pl_carry <>", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryGreaterThan(String value) {
            addCriterion("pl_carry >", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryGreaterThanOrEqualTo(String value) {
            addCriterion("pl_carry >=", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryLessThan(String value) {
            addCriterion("pl_carry <", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryLessThanOrEqualTo(String value) {
            addCriterion("pl_carry <=", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryLike(String value) {
            addCriterion("pl_carry like", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryNotLike(String value) {
            addCriterion("pl_carry not like", value, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryIn(List<String> values) {
            addCriterion("pl_carry in", values, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryNotIn(List<String> values) {
            addCriterion("pl_carry not in", values, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryBetween(String value1, String value2) {
            addCriterion("pl_carry between", value1, value2, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlCarryNotBetween(String value1, String value2) {
            addCriterion("pl_carry not between", value1, value2, "plCarry");
            return (Criteria) this;
        }

        public Criteria andPlStateIsNull() {
            addCriterion("pl_state is null");
            return (Criteria) this;
        }

        public Criteria andPlStateIsNotNull() {
            addCriterion("pl_state is not null");
            return (Criteria) this;
        }

        public Criteria andPlStateEqualTo(String value) {
            addCriterion("pl_state =", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateNotEqualTo(String value) {
            addCriterion("pl_state <>", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateGreaterThan(String value) {
            addCriterion("pl_state >", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateGreaterThanOrEqualTo(String value) {
            addCriterion("pl_state >=", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateLessThan(String value) {
            addCriterion("pl_state <", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateLessThanOrEqualTo(String value) {
            addCriterion("pl_state <=", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateLike(String value) {
            addCriterion("pl_state like", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateNotLike(String value) {
            addCriterion("pl_state not like", value, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateIn(List<String> values) {
            addCriterion("pl_state in", values, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateNotIn(List<String> values) {
            addCriterion("pl_state not in", values, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateBetween(String value1, String value2) {
            addCriterion("pl_state between", value1, value2, "plState");
            return (Criteria) this;
        }

        public Criteria andPlStateNotBetween(String value1, String value2) {
            addCriterion("pl_state not between", value1, value2, "plState");
            return (Criteria) this;
        }

        public Criteria andPlAreaIsNull() {
            addCriterion("pl_area is null");
            return (Criteria) this;
        }

        public Criteria andPlAreaIsNotNull() {
            addCriterion("pl_area is not null");
            return (Criteria) this;
        }

        public Criteria andPlAreaEqualTo(String value) {
            addCriterion("pl_area =", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaNotEqualTo(String value) {
            addCriterion("pl_area <>", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaGreaterThan(String value) {
            addCriterion("pl_area >", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaGreaterThanOrEqualTo(String value) {
            addCriterion("pl_area >=", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaLessThan(String value) {
            addCriterion("pl_area <", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaLessThanOrEqualTo(String value) {
            addCriterion("pl_area <=", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaLike(String value) {
            addCriterion("pl_area like", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaNotLike(String value) {
            addCriterion("pl_area not like", value, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaIn(List<String> values) {
            addCriterion("pl_area in", values, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaNotIn(List<String> values) {
            addCriterion("pl_area not in", values, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaBetween(String value1, String value2) {
            addCriterion("pl_area between", value1, value2, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlAreaNotBetween(String value1, String value2) {
            addCriterion("pl_area not between", value1, value2, "plArea");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepIsNull() {
            addCriterion("pl_ditch_dep is null");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepIsNotNull() {
            addCriterion("pl_ditch_dep is not null");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepEqualTo(String value) {
            addCriterion("pl_ditch_dep =", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepNotEqualTo(String value) {
            addCriterion("pl_ditch_dep <>", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepGreaterThan(String value) {
            addCriterion("pl_ditch_dep >", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepGreaterThanOrEqualTo(String value) {
            addCriterion("pl_ditch_dep >=", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepLessThan(String value) {
            addCriterion("pl_ditch_dep <", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepLessThanOrEqualTo(String value) {
            addCriterion("pl_ditch_dep <=", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepLike(String value) {
            addCriterion("pl_ditch_dep like", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepNotLike(String value) {
            addCriterion("pl_ditch_dep not like", value, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepIn(List<String> values) {
            addCriterion("pl_ditch_dep in", values, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepNotIn(List<String> values) {
            addCriterion("pl_ditch_dep not in", values, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepBetween(String value1, String value2) {
            addCriterion("pl_ditch_dep between", value1, value2, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlDitchDepNotBetween(String value1, String value2) {
            addCriterion("pl_ditch_dep not between", value1, value2, "plDitchDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepIsNull() {
            addCriterion("pl_line_dep is null");
            return (Criteria) this;
        }

        public Criteria andPlLineDepIsNotNull() {
            addCriterion("pl_line_dep is not null");
            return (Criteria) this;
        }

        public Criteria andPlLineDepEqualTo(String value) {
            addCriterion("pl_line_dep =", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepNotEqualTo(String value) {
            addCriterion("pl_line_dep <>", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepGreaterThan(String value) {
            addCriterion("pl_line_dep >", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepGreaterThanOrEqualTo(String value) {
            addCriterion("pl_line_dep >=", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepLessThan(String value) {
            addCriterion("pl_line_dep <", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepLessThanOrEqualTo(String value) {
            addCriterion("pl_line_dep <=", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepLike(String value) {
            addCriterion("pl_line_dep like", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepNotLike(String value) {
            addCriterion("pl_line_dep not like", value, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepIn(List<String> values) {
            addCriterion("pl_line_dep in", values, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepNotIn(List<String> values) {
            addCriterion("pl_line_dep not in", values, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepBetween(String value1, String value2) {
            addCriterion("pl_line_dep between", value1, value2, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlLineDepNotBetween(String value1, String value2) {
            addCriterion("pl_line_dep not between", value1, value2, "plLineDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepIsNull() {
            addCriterion("pl_survey_dep is null");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepIsNotNull() {
            addCriterion("pl_survey_dep is not null");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepEqualTo(String value) {
            addCriterion("pl_survey_dep =", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepNotEqualTo(String value) {
            addCriterion("pl_survey_dep <>", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepGreaterThan(String value) {
            addCriterion("pl_survey_dep >", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepGreaterThanOrEqualTo(String value) {
            addCriterion("pl_survey_dep >=", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepLessThan(String value) {
            addCriterion("pl_survey_dep <", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepLessThanOrEqualTo(String value) {
            addCriterion("pl_survey_dep <=", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepLike(String value) {
            addCriterion("pl_survey_dep like", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepNotLike(String value) {
            addCriterion("pl_survey_dep not like", value, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepIn(List<String> values) {
            addCriterion("pl_survey_dep in", values, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepNotIn(List<String> values) {
            addCriterion("pl_survey_dep not in", values, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepBetween(String value1, String value2) {
            addCriterion("pl_survey_dep between", value1, value2, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyDepNotBetween(String value1, String value2) {
            addCriterion("pl_survey_dep not between", value1, value2, "plSurveyDep");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeIsNull() {
            addCriterion("pl_survey_time is null");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeIsNotNull() {
            addCriterion("pl_survey_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeEqualTo(String value) {
            addCriterion("pl_survey_time =", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeNotEqualTo(String value) {
            addCriterion("pl_survey_time <>", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeGreaterThan(String value) {
            addCriterion("pl_survey_time >", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_survey_time >=", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeLessThan(String value) {
            addCriterion("pl_survey_time <", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeLessThanOrEqualTo(String value) {
            addCriterion("pl_survey_time <=", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeLike(String value) {
            addCriterion("pl_survey_time like", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeNotLike(String value) {
            addCriterion("pl_survey_time not like", value, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeIn(List<String> values) {
            addCriterion("pl_survey_time in", values, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeNotIn(List<String> values) {
            addCriterion("pl_survey_time not in", values, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeBetween(String value1, String value2) {
            addCriterion("pl_survey_time between", value1, value2, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlSurveyTimeNotBetween(String value1, String value2) {
            addCriterion("pl_survey_time not between", value1, value2, "plSurveyTime");
            return (Criteria) this;
        }

        public Criteria andPlPeople1IsNull() {
            addCriterion("pl_people_1 is null");
            return (Criteria) this;
        }

        public Criteria andPlPeople1IsNotNull() {
            addCriterion("pl_people_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPlPeople1EqualTo(String value) {
            addCriterion("pl_people_1 =", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1NotEqualTo(String value) {
            addCriterion("pl_people_1 <>", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1GreaterThan(String value) {
            addCriterion("pl_people_1 >", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1GreaterThanOrEqualTo(String value) {
            addCriterion("pl_people_1 >=", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1LessThan(String value) {
            addCriterion("pl_people_1 <", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1LessThanOrEqualTo(String value) {
            addCriterion("pl_people_1 <=", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1Like(String value) {
            addCriterion("pl_people_1 like", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1NotLike(String value) {
            addCriterion("pl_people_1 not like", value, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1In(List<String> values) {
            addCriterion("pl_people_1 in", values, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1NotIn(List<String> values) {
            addCriterion("pl_people_1 not in", values, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1Between(String value1, String value2) {
            addCriterion("pl_people_1 between", value1, value2, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople1NotBetween(String value1, String value2) {
            addCriterion("pl_people_1 not between", value1, value2, "plPeople1");
            return (Criteria) this;
        }

        public Criteria andPlPeople2IsNull() {
            addCriterion("pl_people_2 is null");
            return (Criteria) this;
        }

        public Criteria andPlPeople2IsNotNull() {
            addCriterion("pl_people_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPlPeople2EqualTo(String value) {
            addCriterion("pl_people_2 =", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2NotEqualTo(String value) {
            addCriterion("pl_people_2 <>", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2GreaterThan(String value) {
            addCriterion("pl_people_2 >", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2GreaterThanOrEqualTo(String value) {
            addCriterion("pl_people_2 >=", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2LessThan(String value) {
            addCriterion("pl_people_2 <", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2LessThanOrEqualTo(String value) {
            addCriterion("pl_people_2 <=", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2Like(String value) {
            addCriterion("pl_people_2 like", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2NotLike(String value) {
            addCriterion("pl_people_2 not like", value, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2In(List<String> values) {
            addCriterion("pl_people_2 in", values, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2NotIn(List<String> values) {
            addCriterion("pl_people_2 not in", values, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2Between(String value1, String value2) {
            addCriterion("pl_people_2 between", value1, value2, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople2NotBetween(String value1, String value2) {
            addCriterion("pl_people_2 not between", value1, value2, "plPeople2");
            return (Criteria) this;
        }

        public Criteria andPlPeople3IsNull() {
            addCriterion("pl_people_3 is null");
            return (Criteria) this;
        }

        public Criteria andPlPeople3IsNotNull() {
            addCriterion("pl_people_3 is not null");
            return (Criteria) this;
        }

        public Criteria andPlPeople3EqualTo(String value) {
            addCriterion("pl_people_3 =", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3NotEqualTo(String value) {
            addCriterion("pl_people_3 <>", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3GreaterThan(String value) {
            addCriterion("pl_people_3 >", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3GreaterThanOrEqualTo(String value) {
            addCriterion("pl_people_3 >=", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3LessThan(String value) {
            addCriterion("pl_people_3 <", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3LessThanOrEqualTo(String value) {
            addCriterion("pl_people_3 <=", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3Like(String value) {
            addCriterion("pl_people_3 like", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3NotLike(String value) {
            addCriterion("pl_people_3 not like", value, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3In(List<String> values) {
            addCriterion("pl_people_3 in", values, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3NotIn(List<String> values) {
            addCriterion("pl_people_3 not in", values, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3Between(String value1, String value2) {
            addCriterion("pl_people_3 between", value1, value2, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPeople3NotBetween(String value1, String value2) {
            addCriterion("pl_people_3 not between", value1, value2, "plPeople3");
            return (Criteria) this;
        }

        public Criteria andPlPidIsNull() {
            addCriterion("pl_pid is null");
            return (Criteria) this;
        }

        public Criteria andPlPidIsNotNull() {
            addCriterion("pl_pid is not null");
            return (Criteria) this;
        }

        public Criteria andPlPidEqualTo(String value) {
            addCriterion("pl_pid =", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidNotEqualTo(String value) {
            addCriterion("pl_pid <>", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidGreaterThan(String value) {
            addCriterion("pl_pid >", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidGreaterThanOrEqualTo(String value) {
            addCriterion("pl_pid >=", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidLessThan(String value) {
            addCriterion("pl_pid <", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidLessThanOrEqualTo(String value) {
            addCriterion("pl_pid <=", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidLike(String value) {
            addCriterion("pl_pid like", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidNotLike(String value) {
            addCriterion("pl_pid not like", value, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidIn(List<String> values) {
            addCriterion("pl_pid in", values, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidNotIn(List<String> values) {
            addCriterion("pl_pid not in", values, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidBetween(String value1, String value2) {
            addCriterion("pl_pid between", value1, value2, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlPidNotBetween(String value1, String value2) {
            addCriterion("pl_pid not between", value1, value2, "plPid");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeIsNull() {
            addCriterion("pl_well_type is null");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeIsNotNull() {
            addCriterion("pl_well_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeEqualTo(String value) {
            addCriterion("pl_well_type =", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeNotEqualTo(String value) {
            addCriterion("pl_well_type <>", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeGreaterThan(String value) {
            addCriterion("pl_well_type >", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_well_type >=", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeLessThan(String value) {
            addCriterion("pl_well_type <", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeLessThanOrEqualTo(String value) {
            addCriterion("pl_well_type <=", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeLike(String value) {
            addCriterion("pl_well_type like", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeNotLike(String value) {
            addCriterion("pl_well_type not like", value, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeIn(List<String> values) {
            addCriterion("pl_well_type in", values, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeNotIn(List<String> values) {
            addCriterion("pl_well_type not in", values, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeBetween(String value1, String value2) {
            addCriterion("pl_well_type between", value1, value2, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlWellTypeNotBetween(String value1, String value2) {
            addCriterion("pl_well_type not between", value1, value2, "plWellType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeIsNull() {
            addCriterion("pl_cover_type is null");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeIsNotNull() {
            addCriterion("pl_cover_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeEqualTo(String value) {
            addCriterion("pl_cover_type =", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeNotEqualTo(String value) {
            addCriterion("pl_cover_type <>", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeGreaterThan(String value) {
            addCriterion("pl_cover_type >", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pl_cover_type >=", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeLessThan(String value) {
            addCriterion("pl_cover_type <", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeLessThanOrEqualTo(String value) {
            addCriterion("pl_cover_type <=", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeLike(String value) {
            addCriterion("pl_cover_type like", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeNotLike(String value) {
            addCriterion("pl_cover_type not like", value, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeIn(List<String> values) {
            addCriterion("pl_cover_type in", values, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeNotIn(List<String> values) {
            addCriterion("pl_cover_type not in", values, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeBetween(String value1, String value2) {
            addCriterion("pl_cover_type between", value1, value2, "plCoverType");
            return (Criteria) this;
        }

        public Criteria andPlCoverTypeNotBetween(String value1, String value2) {
            addCriterion("pl_cover_type not between", value1, value2, "plCoverType");
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