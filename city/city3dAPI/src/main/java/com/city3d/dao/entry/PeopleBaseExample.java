package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PeopleBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleBaseExample() {
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

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityIsNull() {
            addCriterion("mother_identity is null");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityIsNotNull() {
            addCriterion("mother_identity is not null");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityEqualTo(String value) {
            addCriterion("mother_identity =", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityNotEqualTo(String value) {
            addCriterion("mother_identity <>", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityGreaterThan(String value) {
            addCriterion("mother_identity >", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("mother_identity >=", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityLessThan(String value) {
            addCriterion("mother_identity <", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityLessThanOrEqualTo(String value) {
            addCriterion("mother_identity <=", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityLike(String value) {
            addCriterion("mother_identity like", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityNotLike(String value) {
            addCriterion("mother_identity not like", value, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityIn(List<String> values) {
            addCriterion("mother_identity in", values, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityNotIn(List<String> values) {
            addCriterion("mother_identity not in", values, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityBetween(String value1, String value2) {
            addCriterion("mother_identity between", value1, value2, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherIdentityNotBetween(String value1, String value2) {
            addCriterion("mother_identity not between", value1, value2, "motherIdentity");
            return (Criteria) this;
        }

        public Criteria andMotherNameIsNull() {
            addCriterion("mother_name is null");
            return (Criteria) this;
        }

        public Criteria andMotherNameIsNotNull() {
            addCriterion("mother_name is not null");
            return (Criteria) this;
        }

        public Criteria andMotherNameEqualTo(String value) {
            addCriterion("mother_name =", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameNotEqualTo(String value) {
            addCriterion("mother_name <>", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameGreaterThan(String value) {
            addCriterion("mother_name >", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameGreaterThanOrEqualTo(String value) {
            addCriterion("mother_name >=", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameLessThan(String value) {
            addCriterion("mother_name <", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameLessThanOrEqualTo(String value) {
            addCriterion("mother_name <=", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameLike(String value) {
            addCriterion("mother_name like", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameNotLike(String value) {
            addCriterion("mother_name not like", value, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameIn(List<String> values) {
            addCriterion("mother_name in", values, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameNotIn(List<String> values) {
            addCriterion("mother_name not in", values, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameBetween(String value1, String value2) {
            addCriterion("mother_name between", value1, value2, "motherName");
            return (Criteria) this;
        }

        public Criteria andMotherNameNotBetween(String value1, String value2) {
            addCriterion("mother_name not between", value1, value2, "motherName");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andMateIdentityIsNull() {
            addCriterion("mate_identity is null");
            return (Criteria) this;
        }

        public Criteria andMateIdentityIsNotNull() {
            addCriterion("mate_identity is not null");
            return (Criteria) this;
        }

        public Criteria andMateIdentityEqualTo(String value) {
            addCriterion("mate_identity =", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityNotEqualTo(String value) {
            addCriterion("mate_identity <>", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityGreaterThan(String value) {
            addCriterion("mate_identity >", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("mate_identity >=", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityLessThan(String value) {
            addCriterion("mate_identity <", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityLessThanOrEqualTo(String value) {
            addCriterion("mate_identity <=", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityLike(String value) {
            addCriterion("mate_identity like", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityNotLike(String value) {
            addCriterion("mate_identity not like", value, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityIn(List<String> values) {
            addCriterion("mate_identity in", values, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityNotIn(List<String> values) {
            addCriterion("mate_identity not in", values, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityBetween(String value1, String value2) {
            addCriterion("mate_identity between", value1, value2, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateIdentityNotBetween(String value1, String value2) {
            addCriterion("mate_identity not between", value1, value2, "mateIdentity");
            return (Criteria) this;
        }

        public Criteria andMateNameIsNull() {
            addCriterion("mate_name is null");
            return (Criteria) this;
        }

        public Criteria andMateNameIsNotNull() {
            addCriterion("mate_name is not null");
            return (Criteria) this;
        }

        public Criteria andMateNameEqualTo(String value) {
            addCriterion("mate_name =", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameNotEqualTo(String value) {
            addCriterion("mate_name <>", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameGreaterThan(String value) {
            addCriterion("mate_name >", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameGreaterThanOrEqualTo(String value) {
            addCriterion("mate_name >=", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameLessThan(String value) {
            addCriterion("mate_name <", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameLessThanOrEqualTo(String value) {
            addCriterion("mate_name <=", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameLike(String value) {
            addCriterion("mate_name like", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameNotLike(String value) {
            addCriterion("mate_name not like", value, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameIn(List<String> values) {
            addCriterion("mate_name in", values, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameNotIn(List<String> values) {
            addCriterion("mate_name not in", values, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameBetween(String value1, String value2) {
            addCriterion("mate_name between", value1, value2, "mateName");
            return (Criteria) this;
        }

        public Criteria andMateNameNotBetween(String value1, String value2) {
            addCriterion("mate_name not between", value1, value2, "mateName");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeIsNull() {
            addCriterion("community_code is null");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeIsNotNull() {
            addCriterion("community_code is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeEqualTo(String value) {
            addCriterion("community_code =", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotEqualTo(String value) {
            addCriterion("community_code <>", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeGreaterThan(String value) {
            addCriterion("community_code >", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("community_code >=", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLessThan(String value) {
            addCriterion("community_code <", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLessThanOrEqualTo(String value) {
            addCriterion("community_code <=", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLike(String value) {
            addCriterion("community_code like", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotLike(String value) {
            addCriterion("community_code not like", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeIn(List<String> values) {
            addCriterion("community_code in", values, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotIn(List<String> values) {
            addCriterion("community_code not in", values, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeBetween(String value1, String value2) {
            addCriterion("community_code between", value1, value2, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotBetween(String value1, String value2) {
            addCriterion("community_code not between", value1, value2, "communityCode");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCaltureIsNull() {
            addCriterion("calture is null");
            return (Criteria) this;
        }

        public Criteria andCaltureIsNotNull() {
            addCriterion("calture is not null");
            return (Criteria) this;
        }

        public Criteria andCaltureEqualTo(String value) {
            addCriterion("calture =", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureNotEqualTo(String value) {
            addCriterion("calture <>", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureGreaterThan(String value) {
            addCriterion("calture >", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureGreaterThanOrEqualTo(String value) {
            addCriterion("calture >=", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureLessThan(String value) {
            addCriterion("calture <", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureLessThanOrEqualTo(String value) {
            addCriterion("calture <=", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureLike(String value) {
            addCriterion("calture like", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureNotLike(String value) {
            addCriterion("calture not like", value, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureIn(List<String> values) {
            addCriterion("calture in", values, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureNotIn(List<String> values) {
            addCriterion("calture not in", values, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureBetween(String value1, String value2) {
            addCriterion("calture between", value1, value2, "calture");
            return (Criteria) this;
        }

        public Criteria andCaltureNotBetween(String value1, String value2) {
            addCriterion("calture not between", value1, value2, "calture");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNull() {
            addCriterion("blood_type is null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNotNull() {
            addCriterion("blood_type is not null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeEqualTo(String value) {
            addCriterion("blood_type =", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotEqualTo(String value) {
            addCriterion("blood_type <>", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThan(String value) {
            addCriterion("blood_type >", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("blood_type >=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThan(String value) {
            addCriterion("blood_type <", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThanOrEqualTo(String value) {
            addCriterion("blood_type <=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLike(String value) {
            addCriterion("blood_type like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotLike(String value) {
            addCriterion("blood_type not like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIn(List<String> values) {
            addCriterion("blood_type in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotIn(List<String> values) {
            addCriterion("blood_type not in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeBetween(String value1, String value2) {
            addCriterion("blood_type between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotBetween(String value1, String value2) {
            addCriterion("blood_type not between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationIsNull() {
            addCriterion("household_relation is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationIsNotNull() {
            addCriterion("household_relation is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationEqualTo(String value) {
            addCriterion("household_relation =", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationNotEqualTo(String value) {
            addCriterion("household_relation <>", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationGreaterThan(String value) {
            addCriterion("household_relation >", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationGreaterThanOrEqualTo(String value) {
            addCriterion("household_relation >=", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationLessThan(String value) {
            addCriterion("household_relation <", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationLessThanOrEqualTo(String value) {
            addCriterion("household_relation <=", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationLike(String value) {
            addCriterion("household_relation like", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationNotLike(String value) {
            addCriterion("household_relation not like", value, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationIn(List<String> values) {
            addCriterion("household_relation in", values, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationNotIn(List<String> values) {
            addCriterion("household_relation not in", values, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationBetween(String value1, String value2) {
            addCriterion("household_relation between", value1, value2, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andHouseholdRelationNotBetween(String value1, String value2) {
            addCriterion("household_relation not between", value1, value2, "householdRelation");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNull() {
            addCriterion("political is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNotNull() {
            addCriterion("political is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalEqualTo(String value) {
            addCriterion("political =", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotEqualTo(String value) {
            addCriterion("political <>", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThan(String value) {
            addCriterion("political >", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThanOrEqualTo(String value) {
            addCriterion("political >=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThan(String value) {
            addCriterion("political <", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThanOrEqualTo(String value) {
            addCriterion("political <=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLike(String value) {
            addCriterion("political like", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotLike(String value) {
            addCriterion("political not like", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalIn(List<String> values) {
            addCriterion("political in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotIn(List<String> values) {
            addCriterion("political not in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalBetween(String value1, String value2) {
            addCriterion("political between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotBetween(String value1, String value2) {
            addCriterion("political not between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andOnceNameIsNull() {
            addCriterion("once_name is null");
            return (Criteria) this;
        }

        public Criteria andOnceNameIsNotNull() {
            addCriterion("once_name is not null");
            return (Criteria) this;
        }

        public Criteria andOnceNameEqualTo(String value) {
            addCriterion("once_name =", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameNotEqualTo(String value) {
            addCriterion("once_name <>", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameGreaterThan(String value) {
            addCriterion("once_name >", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameGreaterThanOrEqualTo(String value) {
            addCriterion("once_name >=", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameLessThan(String value) {
            addCriterion("once_name <", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameLessThanOrEqualTo(String value) {
            addCriterion("once_name <=", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameLike(String value) {
            addCriterion("once_name like", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameNotLike(String value) {
            addCriterion("once_name not like", value, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameIn(List<String> values) {
            addCriterion("once_name in", values, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameNotIn(List<String> values) {
            addCriterion("once_name not in", values, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameBetween(String value1, String value2) {
            addCriterion("once_name between", value1, value2, "onceName");
            return (Criteria) this;
        }

        public Criteria andOnceNameNotBetween(String value1, String value2) {
            addCriterion("once_name not between", value1, value2, "onceName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityIsNull() {
            addCriterion("father_identity is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityIsNotNull() {
            addCriterion("father_identity is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityEqualTo(String value) {
            addCriterion("father_identity =", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityNotEqualTo(String value) {
            addCriterion("father_identity <>", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityGreaterThan(String value) {
            addCriterion("father_identity >", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("father_identity >=", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityLessThan(String value) {
            addCriterion("father_identity <", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityLessThanOrEqualTo(String value) {
            addCriterion("father_identity <=", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityLike(String value) {
            addCriterion("father_identity like", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityNotLike(String value) {
            addCriterion("father_identity not like", value, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityIn(List<String> values) {
            addCriterion("father_identity in", values, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityNotIn(List<String> values) {
            addCriterion("father_identity not in", values, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityBetween(String value1, String value2) {
            addCriterion("father_identity between", value1, value2, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherIdentityNotBetween(String value1, String value2) {
            addCriterion("father_identity not between", value1, value2, "fatherIdentity");
            return (Criteria) this;
        }

        public Criteria andFatherNameIsNull() {
            addCriterion("father_name is null");
            return (Criteria) this;
        }

        public Criteria andFatherNameIsNotNull() {
            addCriterion("father_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatherNameEqualTo(String value) {
            addCriterion("father_name =", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameNotEqualTo(String value) {
            addCriterion("father_name <>", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameGreaterThan(String value) {
            addCriterion("father_name >", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameGreaterThanOrEqualTo(String value) {
            addCriterion("father_name >=", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameLessThan(String value) {
            addCriterion("father_name <", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameLessThanOrEqualTo(String value) {
            addCriterion("father_name <=", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameLike(String value) {
            addCriterion("father_name like", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameNotLike(String value) {
            addCriterion("father_name not like", value, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameIn(List<String> values) {
            addCriterion("father_name in", values, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameNotIn(List<String> values) {
            addCriterion("father_name not in", values, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameBetween(String value1, String value2) {
            addCriterion("father_name between", value1, value2, "fatherName");
            return (Criteria) this;
        }

        public Criteria andFatherNameNotBetween(String value1, String value2) {
            addCriterion("father_name not between", value1, value2, "fatherName");
            return (Criteria) this;
        }

        public Criteria andIdentity1IsNull() {
            addCriterion("identity1 is null");
            return (Criteria) this;
        }

        public Criteria andIdentity1IsNotNull() {
            addCriterion("identity1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdentity1EqualTo(String value) {
            addCriterion("identity1 =", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1NotEqualTo(String value) {
            addCriterion("identity1 <>", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1GreaterThan(String value) {
            addCriterion("identity1 >", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1GreaterThanOrEqualTo(String value) {
            addCriterion("identity1 >=", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1LessThan(String value) {
            addCriterion("identity1 <", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1LessThanOrEqualTo(String value) {
            addCriterion("identity1 <=", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1Like(String value) {
            addCriterion("identity1 like", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1NotLike(String value) {
            addCriterion("identity1 not like", value, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1In(List<String> values) {
            addCriterion("identity1 in", values, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1NotIn(List<String> values) {
            addCriterion("identity1 not in", values, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1Between(String value1, String value2) {
            addCriterion("identity1 between", value1, value2, "identity1");
            return (Criteria) this;
        }

        public Criteria andIdentity1NotBetween(String value1, String value2) {
            addCriterion("identity1 not between", value1, value2, "identity1");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoIsNull() {
            addCriterion("household_no is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoIsNotNull() {
            addCriterion("household_no is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoEqualTo(String value) {
            addCriterion("household_no =", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoNotEqualTo(String value) {
            addCriterion("household_no <>", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoGreaterThan(String value) {
            addCriterion("household_no >", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoGreaterThanOrEqualTo(String value) {
            addCriterion("household_no >=", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoLessThan(String value) {
            addCriterion("household_no <", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoLessThanOrEqualTo(String value) {
            addCriterion("household_no <=", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoLike(String value) {
            addCriterion("household_no like", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoNotLike(String value) {
            addCriterion("household_no not like", value, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoIn(List<String> values) {
            addCriterion("household_no in", values, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoNotIn(List<String> values) {
            addCriterion("household_no not in", values, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoBetween(String value1, String value2) {
            addCriterion("household_no between", value1, value2, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdNoNotBetween(String value1, String value2) {
            addCriterion("household_no not between", value1, value2, "householdNo");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIsNull() {
            addCriterion("household_address is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIsNotNull() {
            addCriterion("household_address is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressEqualTo(String value) {
            addCriterion("household_address =", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotEqualTo(String value) {
            addCriterion("household_address <>", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressGreaterThan(String value) {
            addCriterion("household_address >", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("household_address >=", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLessThan(String value) {
            addCriterion("household_address <", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLessThanOrEqualTo(String value) {
            addCriterion("household_address <=", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressLike(String value) {
            addCriterion("household_address like", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotLike(String value) {
            addCriterion("household_address not like", value, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressIn(List<String> values) {
            addCriterion("household_address in", values, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotIn(List<String> values) {
            addCriterion("household_address not in", values, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressBetween(String value1, String value2) {
            addCriterion("household_address between", value1, value2, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdAddressNotBetween(String value1, String value2) {
            addCriterion("household_address not between", value1, value2, "householdAddress");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceIsNull() {
            addCriterion("household_porvince is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceIsNotNull() {
            addCriterion("household_porvince is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceEqualTo(String value) {
            addCriterion("household_porvince =", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceNotEqualTo(String value) {
            addCriterion("household_porvince <>", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceGreaterThan(String value) {
            addCriterion("household_porvince >", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceGreaterThanOrEqualTo(String value) {
            addCriterion("household_porvince >=", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceLessThan(String value) {
            addCriterion("household_porvince <", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceLessThanOrEqualTo(String value) {
            addCriterion("household_porvince <=", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceLike(String value) {
            addCriterion("household_porvince like", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceNotLike(String value) {
            addCriterion("household_porvince not like", value, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceIn(List<String> values) {
            addCriterion("household_porvince in", values, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceNotIn(List<String> values) {
            addCriterion("household_porvince not in", values, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceBetween(String value1, String value2) {
            addCriterion("household_porvince between", value1, value2, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdPorvinceNotBetween(String value1, String value2) {
            addCriterion("household_porvince not between", value1, value2, "householdPorvince");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureIsNull() {
            addCriterion("household_nature is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureIsNotNull() {
            addCriterion("household_nature is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureEqualTo(String value) {
            addCriterion("household_nature =", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureNotEqualTo(String value) {
            addCriterion("household_nature <>", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureGreaterThan(String value) {
            addCriterion("household_nature >", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureGreaterThanOrEqualTo(String value) {
            addCriterion("household_nature >=", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureLessThan(String value) {
            addCriterion("household_nature <", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureLessThanOrEqualTo(String value) {
            addCriterion("household_nature <=", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureLike(String value) {
            addCriterion("household_nature like", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureNotLike(String value) {
            addCriterion("household_nature not like", value, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureIn(List<String> values) {
            addCriterion("household_nature in", values, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureNotIn(List<String> values) {
            addCriterion("household_nature not in", values, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureBetween(String value1, String value2) {
            addCriterion("household_nature between", value1, value2, "householdNature");
            return (Criteria) this;
        }

        public Criteria andHouseholdNatureNotBetween(String value1, String value2) {
            addCriterion("household_nature not between", value1, value2, "householdNature");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryIsNull() {
            addCriterion("native_place_country is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryIsNotNull() {
            addCriterion("native_place_country is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryEqualTo(String value) {
            addCriterion("native_place_country =", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryNotEqualTo(String value) {
            addCriterion("native_place_country <>", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryGreaterThan(String value) {
            addCriterion("native_place_country >", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryGreaterThanOrEqualTo(String value) {
            addCriterion("native_place_country >=", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryLessThan(String value) {
            addCriterion("native_place_country <", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryLessThanOrEqualTo(String value) {
            addCriterion("native_place_country <=", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryLike(String value) {
            addCriterion("native_place_country like", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryNotLike(String value) {
            addCriterion("native_place_country not like", value, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryIn(List<String> values) {
            addCriterion("native_place_country in", values, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryNotIn(List<String> values) {
            addCriterion("native_place_country not in", values, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryBetween(String value1, String value2) {
            addCriterion("native_place_country between", value1, value2, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceCountryNotBetween(String value1, String value2) {
            addCriterion("native_place_country not between", value1, value2, "nativePlaceCountry");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceIsNull() {
            addCriterion("native_place_province is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceIsNotNull() {
            addCriterion("native_place_province is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceEqualTo(String value) {
            addCriterion("native_place_province =", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceNotEqualTo(String value) {
            addCriterion("native_place_province <>", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceGreaterThan(String value) {
            addCriterion("native_place_province >", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place_province >=", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceLessThan(String value) {
            addCriterion("native_place_province <", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceLessThanOrEqualTo(String value) {
            addCriterion("native_place_province <=", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceLike(String value) {
            addCriterion("native_place_province like", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceNotLike(String value) {
            addCriterion("native_place_province not like", value, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceIn(List<String> values) {
            addCriterion("native_place_province in", values, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceNotIn(List<String> values) {
            addCriterion("native_place_province not in", values, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceBetween(String value1, String value2) {
            addCriterion("native_place_province between", value1, value2, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andNativePlaceProvinceNotBetween(String value1, String value2) {
            addCriterion("native_place_province not between", value1, value2, "nativePlaceProvince");
            return (Criteria) this;
        }

        public Criteria andFromCountryIsNull() {
            addCriterion("from_country is null");
            return (Criteria) this;
        }

        public Criteria andFromCountryIsNotNull() {
            addCriterion("from_country is not null");
            return (Criteria) this;
        }

        public Criteria andFromCountryEqualTo(String value) {
            addCriterion("from_country =", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryNotEqualTo(String value) {
            addCriterion("from_country <>", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryGreaterThan(String value) {
            addCriterion("from_country >", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryGreaterThanOrEqualTo(String value) {
            addCriterion("from_country >=", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryLessThan(String value) {
            addCriterion("from_country <", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryLessThanOrEqualTo(String value) {
            addCriterion("from_country <=", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryLike(String value) {
            addCriterion("from_country like", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryNotLike(String value) {
            addCriterion("from_country not like", value, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryIn(List<String> values) {
            addCriterion("from_country in", values, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryNotIn(List<String> values) {
            addCriterion("from_country not in", values, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryBetween(String value1, String value2) {
            addCriterion("from_country between", value1, value2, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromCountryNotBetween(String value1, String value2) {
            addCriterion("from_country not between", value1, value2, "fromCountry");
            return (Criteria) this;
        }

        public Criteria andFromAddressIsNull() {
            addCriterion("from_address is null");
            return (Criteria) this;
        }

        public Criteria andFromAddressIsNotNull() {
            addCriterion("from_address is not null");
            return (Criteria) this;
        }

        public Criteria andFromAddressEqualTo(String value) {
            addCriterion("from_address =", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotEqualTo(String value) {
            addCriterion("from_address <>", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressGreaterThan(String value) {
            addCriterion("from_address >", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressGreaterThanOrEqualTo(String value) {
            addCriterion("from_address >=", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLessThan(String value) {
            addCriterion("from_address <", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLessThanOrEqualTo(String value) {
            addCriterion("from_address <=", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLike(String value) {
            addCriterion("from_address like", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotLike(String value) {
            addCriterion("from_address not like", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressIn(List<String> values) {
            addCriterion("from_address in", values, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotIn(List<String> values) {
            addCriterion("from_address not in", values, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressBetween(String value1, String value2) {
            addCriterion("from_address between", value1, value2, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotBetween(String value1, String value2) {
            addCriterion("from_address not between", value1, value2, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromProvinceIsNull() {
            addCriterion("from_province is null");
            return (Criteria) this;
        }

        public Criteria andFromProvinceIsNotNull() {
            addCriterion("from_province is not null");
            return (Criteria) this;
        }

        public Criteria andFromProvinceEqualTo(String value) {
            addCriterion("from_province =", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceNotEqualTo(String value) {
            addCriterion("from_province <>", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceGreaterThan(String value) {
            addCriterion("from_province >", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("from_province >=", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceLessThan(String value) {
            addCriterion("from_province <", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceLessThanOrEqualTo(String value) {
            addCriterion("from_province <=", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceLike(String value) {
            addCriterion("from_province like", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceNotLike(String value) {
            addCriterion("from_province not like", value, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceIn(List<String> values) {
            addCriterion("from_province in", values, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceNotIn(List<String> values) {
            addCriterion("from_province not in", values, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceBetween(String value1, String value2) {
            addCriterion("from_province between", value1, value2, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andFromProvinceNotBetween(String value1, String value2) {
            addCriterion("from_province not between", value1, value2, "fromProvince");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(String value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(String value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(String value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(String value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(String value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(String value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLike(String value) {
            addCriterion("in_date like", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotLike(String value) {
            addCriterion("in_date not like", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<String> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<String> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(String value1, String value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(String value1, String value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInReasonIsNull() {
            addCriterion("in_reason is null");
            return (Criteria) this;
        }

        public Criteria andInReasonIsNotNull() {
            addCriterion("in_reason is not null");
            return (Criteria) this;
        }

        public Criteria andInReasonEqualTo(String value) {
            addCriterion("in_reason =", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotEqualTo(String value) {
            addCriterion("in_reason <>", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonGreaterThan(String value) {
            addCriterion("in_reason >", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonGreaterThanOrEqualTo(String value) {
            addCriterion("in_reason >=", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLessThan(String value) {
            addCriterion("in_reason <", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLessThanOrEqualTo(String value) {
            addCriterion("in_reason <=", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLike(String value) {
            addCriterion("in_reason like", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotLike(String value) {
            addCriterion("in_reason not like", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonIn(List<String> values) {
            addCriterion("in_reason in", values, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotIn(List<String> values) {
            addCriterion("in_reason not in", values, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonBetween(String value1, String value2) {
            addCriterion("in_reason between", value1, value2, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotBetween(String value1, String value2) {
            addCriterion("in_reason not between", value1, value2, "inReason");
            return (Criteria) this;
        }

        public Criteria andServeArmyIsNull() {
            addCriterion("serve_army is null");
            return (Criteria) this;
        }

        public Criteria andServeArmyIsNotNull() {
            addCriterion("serve_army is not null");
            return (Criteria) this;
        }

        public Criteria andServeArmyEqualTo(String value) {
            addCriterion("serve_army =", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyNotEqualTo(String value) {
            addCriterion("serve_army <>", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyGreaterThan(String value) {
            addCriterion("serve_army >", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyGreaterThanOrEqualTo(String value) {
            addCriterion("serve_army >=", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyLessThan(String value) {
            addCriterion("serve_army <", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyLessThanOrEqualTo(String value) {
            addCriterion("serve_army <=", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyLike(String value) {
            addCriterion("serve_army like", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyNotLike(String value) {
            addCriterion("serve_army not like", value, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyIn(List<String> values) {
            addCriterion("serve_army in", values, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyNotIn(List<String> values) {
            addCriterion("serve_army not in", values, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyBetween(String value1, String value2) {
            addCriterion("serve_army between", value1, value2, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andServeArmyNotBetween(String value1, String value2) {
            addCriterion("serve_army not between", value1, value2, "serveArmy");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationIsNull() {
            addCriterion("overseas_relation is null");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationIsNotNull() {
            addCriterion("overseas_relation is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationEqualTo(String value) {
            addCriterion("overseas_relation =", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationNotEqualTo(String value) {
            addCriterion("overseas_relation <>", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationGreaterThan(String value) {
            addCriterion("overseas_relation >", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationGreaterThanOrEqualTo(String value) {
            addCriterion("overseas_relation >=", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationLessThan(String value) {
            addCriterion("overseas_relation <", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationLessThanOrEqualTo(String value) {
            addCriterion("overseas_relation <=", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationLike(String value) {
            addCriterion("overseas_relation like", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationNotLike(String value) {
            addCriterion("overseas_relation not like", value, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationIn(List<String> values) {
            addCriterion("overseas_relation in", values, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationNotIn(List<String> values) {
            addCriterion("overseas_relation not in", values, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationBetween(String value1, String value2) {
            addCriterion("overseas_relation between", value1, value2, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andOverseasRelationNotBetween(String value1, String value2) {
            addCriterion("overseas_relation not between", value1, value2, "overseasRelation");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeIsNull() {
            addCriterion("people_type is null");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeIsNotNull() {
            addCriterion("people_type is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeEqualTo(String value) {
            addCriterion("people_type =", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeNotEqualTo(String value) {
            addCriterion("people_type <>", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeGreaterThan(String value) {
            addCriterion("people_type >", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("people_type >=", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeLessThan(String value) {
            addCriterion("people_type <", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeLessThanOrEqualTo(String value) {
            addCriterion("people_type <=", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeLike(String value) {
            addCriterion("people_type like", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeNotLike(String value) {
            addCriterion("people_type not like", value, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeIn(List<String> values) {
            addCriterion("people_type in", values, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeNotIn(List<String> values) {
            addCriterion("people_type not in", values, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeBetween(String value1, String value2) {
            addCriterion("people_type between", value1, value2, "peopleType");
            return (Criteria) this;
        }

        public Criteria andPeopleTypeNotBetween(String value1, String value2) {
            addCriterion("people_type not between", value1, value2, "peopleType");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgurl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgurl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgOtherIsNull() {
            addCriterion("img_other is null");
            return (Criteria) this;
        }

        public Criteria andImgOtherIsNotNull() {
            addCriterion("img_other is not null");
            return (Criteria) this;
        }

        public Criteria andImgOtherEqualTo(String value) {
            addCriterion("img_other =", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherNotEqualTo(String value) {
            addCriterion("img_other <>", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherGreaterThan(String value) {
            addCriterion("img_other >", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherGreaterThanOrEqualTo(String value) {
            addCriterion("img_other >=", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherLessThan(String value) {
            addCriterion("img_other <", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherLessThanOrEqualTo(String value) {
            addCriterion("img_other <=", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherLike(String value) {
            addCriterion("img_other like", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherNotLike(String value) {
            addCriterion("img_other not like", value, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherIn(List<String> values) {
            addCriterion("img_other in", values, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherNotIn(List<String> values) {
            addCriterion("img_other not in", values, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherBetween(String value1, String value2) {
            addCriterion("img_other between", value1, value2, "imgOther");
            return (Criteria) this;
        }

        public Criteria andImgOtherNotBetween(String value1, String value2) {
            addCriterion("img_other not between", value1, value2, "imgOther");
            return (Criteria) this;
        }

        public Criteria andSkillIsNull() {
            addCriterion("skill is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("skill is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(String value) {
            addCriterion("skill =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(String value) {
            addCriterion("skill <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(String value) {
            addCriterion("skill >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(String value) {
            addCriterion("skill >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(String value) {
            addCriterion("skill <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(String value) {
            addCriterion("skill <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLike(String value) {
            addCriterion("skill like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotLike(String value) {
            addCriterion("skill not like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<String> values) {
            addCriterion("skill in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<String> values) {
            addCriterion("skill not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(String value1, String value2) {
            addCriterion("skill between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(String value1, String value2) {
            addCriterion("skill not between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andEntryTypeIsNull() {
            addCriterion("entry_type is null");
            return (Criteria) this;
        }

        public Criteria andEntryTypeIsNotNull() {
            addCriterion("entry_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTypeEqualTo(String value) {
            addCriterion("entry_type =", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeNotEqualTo(String value) {
            addCriterion("entry_type <>", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeGreaterThan(String value) {
            addCriterion("entry_type >", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("entry_type >=", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeLessThan(String value) {
            addCriterion("entry_type <", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeLessThanOrEqualTo(String value) {
            addCriterion("entry_type <=", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeLike(String value) {
            addCriterion("entry_type like", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeNotLike(String value) {
            addCriterion("entry_type not like", value, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeIn(List<String> values) {
            addCriterion("entry_type in", values, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeNotIn(List<String> values) {
            addCriterion("entry_type not in", values, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeBetween(String value1, String value2) {
            addCriterion("entry_type between", value1, value2, "entryType");
            return (Criteria) this;
        }

        public Criteria andEntryTypeNotBetween(String value1, String value2) {
            addCriterion("entry_type not between", value1, value2, "entryType");
            return (Criteria) this;
        }

        public Criteria andIsDrugIsNull() {
            addCriterion("is_drug is null");
            return (Criteria) this;
        }

        public Criteria andIsDrugIsNotNull() {
            addCriterion("is_drug is not null");
            return (Criteria) this;
        }

        public Criteria andIsDrugEqualTo(String value) {
            addCriterion("is_drug =", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotEqualTo(String value) {
            addCriterion("is_drug <>", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugGreaterThan(String value) {
            addCriterion("is_drug >", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugGreaterThanOrEqualTo(String value) {
            addCriterion("is_drug >=", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugLessThan(String value) {
            addCriterion("is_drug <", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugLessThanOrEqualTo(String value) {
            addCriterion("is_drug <=", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugLike(String value) {
            addCriterion("is_drug like", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotLike(String value) {
            addCriterion("is_drug not like", value, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugIn(List<String> values) {
            addCriterion("is_drug in", values, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotIn(List<String> values) {
            addCriterion("is_drug not in", values, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugBetween(String value1, String value2) {
            addCriterion("is_drug between", value1, value2, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsDrugNotBetween(String value1, String value2) {
            addCriterion("is_drug not between", value1, value2, "isDrug");
            return (Criteria) this;
        }

        public Criteria andIsFlowIsNull() {
            addCriterion("is_flow is null");
            return (Criteria) this;
        }

        public Criteria andIsFlowIsNotNull() {
            addCriterion("is_flow is not null");
            return (Criteria) this;
        }

        public Criteria andIsFlowEqualTo(String value) {
            addCriterion("is_flow =", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowNotEqualTo(String value) {
            addCriterion("is_flow <>", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowGreaterThan(String value) {
            addCriterion("is_flow >", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowGreaterThanOrEqualTo(String value) {
            addCriterion("is_flow >=", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowLessThan(String value) {
            addCriterion("is_flow <", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowLessThanOrEqualTo(String value) {
            addCriterion("is_flow <=", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowLike(String value) {
            addCriterion("is_flow like", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowNotLike(String value) {
            addCriterion("is_flow not like", value, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowIn(List<String> values) {
            addCriterion("is_flow in", values, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowNotIn(List<String> values) {
            addCriterion("is_flow not in", values, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowBetween(String value1, String value2) {
            addCriterion("is_flow between", value1, value2, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsFlowNotBetween(String value1, String value2) {
            addCriterion("is_flow not between", value1, value2, "isFlow");
            return (Criteria) this;
        }

        public Criteria andIsImportantIsNull() {
            addCriterion("is_important is null");
            return (Criteria) this;
        }

        public Criteria andIsImportantIsNotNull() {
            addCriterion("is_important is not null");
            return (Criteria) this;
        }

        public Criteria andIsImportantEqualTo(String value) {
            addCriterion("is_important =", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantNotEqualTo(String value) {
            addCriterion("is_important <>", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantGreaterThan(String value) {
            addCriterion("is_important >", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantGreaterThanOrEqualTo(String value) {
            addCriterion("is_important >=", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantLessThan(String value) {
            addCriterion("is_important <", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantLessThanOrEqualTo(String value) {
            addCriterion("is_important <=", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantLike(String value) {
            addCriterion("is_important like", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantNotLike(String value) {
            addCriterion("is_important not like", value, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantIn(List<String> values) {
            addCriterion("is_important in", values, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantNotIn(List<String> values) {
            addCriterion("is_important not in", values, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantBetween(String value1, String value2) {
            addCriterion("is_important between", value1, value2, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsImportantNotBetween(String value1, String value2) {
            addCriterion("is_important not between", value1, value2, "isImportant");
            return (Criteria) this;
        }

        public Criteria andIsLostIsNull() {
            addCriterion("is_lost is null");
            return (Criteria) this;
        }

        public Criteria andIsLostIsNotNull() {
            addCriterion("is_lost is not null");
            return (Criteria) this;
        }

        public Criteria andIsLostEqualTo(String value) {
            addCriterion("is_lost =", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostNotEqualTo(String value) {
            addCriterion("is_lost <>", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostGreaterThan(String value) {
            addCriterion("is_lost >", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostGreaterThanOrEqualTo(String value) {
            addCriterion("is_lost >=", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostLessThan(String value) {
            addCriterion("is_lost <", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostLessThanOrEqualTo(String value) {
            addCriterion("is_lost <=", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostLike(String value) {
            addCriterion("is_lost like", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostNotLike(String value) {
            addCriterion("is_lost not like", value, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostIn(List<String> values) {
            addCriterion("is_lost in", values, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostNotIn(List<String> values) {
            addCriterion("is_lost not in", values, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostBetween(String value1, String value2) {
            addCriterion("is_lost between", value1, value2, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsLostNotBetween(String value1, String value2) {
            addCriterion("is_lost not between", value1, value2, "isLost");
            return (Criteria) this;
        }

        public Criteria andIsMentalIsNull() {
            addCriterion("is_mental is null");
            return (Criteria) this;
        }

        public Criteria andIsMentalIsNotNull() {
            addCriterion("is_mental is not null");
            return (Criteria) this;
        }

        public Criteria andIsMentalEqualTo(String value) {
            addCriterion("is_mental =", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalNotEqualTo(String value) {
            addCriterion("is_mental <>", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalGreaterThan(String value) {
            addCriterion("is_mental >", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalGreaterThanOrEqualTo(String value) {
            addCriterion("is_mental >=", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalLessThan(String value) {
            addCriterion("is_mental <", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalLessThanOrEqualTo(String value) {
            addCriterion("is_mental <=", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalLike(String value) {
            addCriterion("is_mental like", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalNotLike(String value) {
            addCriterion("is_mental not like", value, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalIn(List<String> values) {
            addCriterion("is_mental in", values, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalNotIn(List<String> values) {
            addCriterion("is_mental not in", values, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalBetween(String value1, String value2) {
            addCriterion("is_mental between", value1, value2, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsMentalNotBetween(String value1, String value2) {
            addCriterion("is_mental not between", value1, value2, "isMental");
            return (Criteria) this;
        }

        public Criteria andIsOutIsNull() {
            addCriterion("is_out is null");
            return (Criteria) this;
        }

        public Criteria andIsOutIsNotNull() {
            addCriterion("is_out is not null");
            return (Criteria) this;
        }

        public Criteria andIsOutEqualTo(String value) {
            addCriterion("is_out =", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutNotEqualTo(String value) {
            addCriterion("is_out <>", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutGreaterThan(String value) {
            addCriterion("is_out >", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutGreaterThanOrEqualTo(String value) {
            addCriterion("is_out >=", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutLessThan(String value) {
            addCriterion("is_out <", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutLessThanOrEqualTo(String value) {
            addCriterion("is_out <=", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutLike(String value) {
            addCriterion("is_out like", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutNotLike(String value) {
            addCriterion("is_out not like", value, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutIn(List<String> values) {
            addCriterion("is_out in", values, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutNotIn(List<String> values) {
            addCriterion("is_out not in", values, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutBetween(String value1, String value2) {
            addCriterion("is_out between", value1, value2, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsOutNotBetween(String value1, String value2) {
            addCriterion("is_out not between", value1, value2, "isOut");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseIsNull() {
            addCriterion("is_supervise is null");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseIsNotNull() {
            addCriterion("is_supervise is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseEqualTo(String value) {
            addCriterion("is_supervise =", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseNotEqualTo(String value) {
            addCriterion("is_supervise <>", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseGreaterThan(String value) {
            addCriterion("is_supervise >", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseGreaterThanOrEqualTo(String value) {
            addCriterion("is_supervise >=", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseLessThan(String value) {
            addCriterion("is_supervise <", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseLessThanOrEqualTo(String value) {
            addCriterion("is_supervise <=", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseLike(String value) {
            addCriterion("is_supervise like", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseNotLike(String value) {
            addCriterion("is_supervise not like", value, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseIn(List<String> values) {
            addCriterion("is_supervise in", values, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseNotIn(List<String> values) {
            addCriterion("is_supervise not in", values, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseBetween(String value1, String value2) {
            addCriterion("is_supervise between", value1, value2, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsSuperviseNotBetween(String value1, String value2) {
            addCriterion("is_supervise not between", value1, value2, "isSupervise");
            return (Criteria) this;
        }

        public Criteria andIsVisitIsNull() {
            addCriterion("is_visit is null");
            return (Criteria) this;
        }

        public Criteria andIsVisitIsNotNull() {
            addCriterion("is_visit is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisitEqualTo(String value) {
            addCriterion("is_visit =", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotEqualTo(String value) {
            addCriterion("is_visit <>", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitGreaterThan(String value) {
            addCriterion("is_visit >", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitGreaterThanOrEqualTo(String value) {
            addCriterion("is_visit >=", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitLessThan(String value) {
            addCriterion("is_visit <", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitLessThanOrEqualTo(String value) {
            addCriterion("is_visit <=", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitLike(String value) {
            addCriterion("is_visit like", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotLike(String value) {
            addCriterion("is_visit not like", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitIn(List<String> values) {
            addCriterion("is_visit in", values, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotIn(List<String> values) {
            addCriterion("is_visit not in", values, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitBetween(String value1, String value2) {
            addCriterion("is_visit between", value1, value2, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotBetween(String value1, String value2) {
            addCriterion("is_visit not between", value1, value2, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangIsNull() {
            addCriterion("is_xinjiang is null");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangIsNotNull() {
            addCriterion("is_xinjiang is not null");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangEqualTo(String value) {
            addCriterion("is_xinjiang =", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangNotEqualTo(String value) {
            addCriterion("is_xinjiang <>", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangGreaterThan(String value) {
            addCriterion("is_xinjiang >", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangGreaterThanOrEqualTo(String value) {
            addCriterion("is_xinjiang >=", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangLessThan(String value) {
            addCriterion("is_xinjiang <", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangLessThanOrEqualTo(String value) {
            addCriterion("is_xinjiang <=", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangLike(String value) {
            addCriterion("is_xinjiang like", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangNotLike(String value) {
            addCriterion("is_xinjiang not like", value, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangIn(List<String> values) {
            addCriterion("is_xinjiang in", values, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangNotIn(List<String> values) {
            addCriterion("is_xinjiang not in", values, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangBetween(String value1, String value2) {
            addCriterion("is_xinjiang between", value1, value2, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsXinjiangNotBetween(String value1, String value2) {
            addCriterion("is_xinjiang not between", value1, value2, "isXinjiang");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNull() {
            addCriterion("is_key is null");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNotNull() {
            addCriterion("is_key is not null");
            return (Criteria) this;
        }

        public Criteria andIsKeyEqualTo(String value) {
            addCriterion("is_key =", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotEqualTo(String value) {
            addCriterion("is_key <>", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThan(String value) {
            addCriterion("is_key >", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("is_key >=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThan(String value) {
            addCriterion("is_key <", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThanOrEqualTo(String value) {
            addCriterion("is_key <=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLike(String value) {
            addCriterion("is_key like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotLike(String value) {
            addCriterion("is_key not like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyIn(List<String> values) {
            addCriterion("is_key in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotIn(List<String> values) {
            addCriterion("is_key not in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyBetween(String value1, String value2) {
            addCriterion("is_key between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotBetween(String value1, String value2) {
            addCriterion("is_key not between", value1, value2, "isKey");
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