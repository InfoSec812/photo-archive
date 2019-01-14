package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
public class ImageObject {

  private String about;
  private String accessibilityapi;
  private String accessibilitycontrol;
  private String accessibilityfeature;
  private String accessibilityhazard;
  private String accountableperson;
  private String additionaltype;
  private String aggregaterating;
  private String alternatename;
  private String alternativeheadline;
  private String associatedarticle;
  private String associatedmedia;
  private String audience;
  private String audio;
  private String author;
  private String award;
  private Integer bitrate;
  private String caption;
  private String character;
  private String citation;
  private String comment;
  private Integer commentcount;
  private String contentlocation;
  private String contentrating;
  private String contentsize;
  private String contenturl;
  private String contributor;
  private String copyrightholder;
  private Float copyrightyear;
  private String creator;
  private String datecreated;
  private String datemodified;
  private String datepublished;
  private String description;
  private String diagram;
  private String discussionurl;
  private String duration;
  private String editor;
  private String educationalalignment;
  private String educationaluse;
  private String embedurl;
  private String encodescreativework;
  private String encoding;
  private String encodingformat;
  private String exampleofwork;
  private String exifdata;
  private String expires;
  private String fileformat;
  private String genre;
  private String haspart;
  private String headline;
  private Integer height;
  private String image;
  private String inlanguage;
  private Integer interactionstatistic;
  private String interactivitytype;
  private String isbasedonurl;
  private Boolean isfamilyfriendly;
  private String ispartof;
  private String keywords;
  private String learningresourcetype;
  private String license;
  private String locationcreated;
  private String logo;
  private String mainentity;
  private String mainentityofpage;
  private String mentions;
  private String name;
  private String offers;
  private String photo;
  private String playertype;
  private String position;
  private String potentialaction;
  private String primaryimageofpage;
  private String producer;
  private String productioncompany;
  private String provider;
  private String publication;
  private String publisher;
  private String publishingprinciples;
  private String recordedat;
  private String regionsallowed;
  private String releasedevent;
  private Boolean representativeofpage;
  private Boolean requiressubscription;
  private String review;
  private String sameas;
  private String schemaversion;
  private String screenshot;
  private String sourceorganization;
  private String text;
  private String thumbnail;
  private String thumbnailurl;
  private String timerequired;
  private String translator;
  private String typicalagerange;
  private String uploaddate;
  private String url;
  private Float version;
  private String video;
  private Integer width;
  private String workexample;

  public ImageObject (
    String about,
    String accessibilityapi,
    String accessibilitycontrol,
    String accessibilityfeature,
    String accessibilityhazard,
    String accountableperson,
    String additionaltype,
    String aggregaterating,
    String alternatename,
    String alternativeheadline,
    String associatedarticle,
    String associatedmedia,
    String audience,
    String audio,
    String author,
    String award,
    Integer bitrate,
    String caption,
    String character,
    String citation,
    String comment,
    Integer commentcount,
    String contentlocation,
    String contentrating,
    String contentsize,
    String contenturl,
    String contributor,
    String copyrightholder,
    Float copyrightyear,
    String creator,
    String datecreated,
    String datemodified,
    String datepublished,
    String description,
    String diagram,
    String discussionurl,
    String duration,
    String editor,
    String educationalalignment,
    String educationaluse,
    String embedurl,
    String encodescreativework,
    String encoding,
    String encodingformat,
    String exampleofwork,
    String exifdata,
    String expires,
    String fileformat,
    String genre,
    String haspart,
    String headline,
    Integer height,
    String image,
    String inlanguage,
    Integer interactionstatistic,
    String interactivitytype,
    String isbasedonurl,
    Boolean isfamilyfriendly,
    String ispartof,
    String keywords,
    String learningresourcetype,
    String license,
    String locationcreated,
    String logo,
    String mainentity,
    String mainentityofpage,
    String mentions,
    String name,
    String offers,
    String photo,
    String playertype,
    String position,
    String potentialaction,
    String primaryimageofpage,
    String producer,
    String productioncompany,
    String provider,
    String publication,
    String publisher,
    String publishingprinciples,
    String recordedat,
    String regionsallowed,
    String releasedevent,
    Boolean representativeofpage,
    Boolean requiressubscription,
    String review,
    String sameas,
    String schemaversion,
    String screenshot,
    String sourceorganization,
    String text,
    String thumbnail,
    String thumbnailurl,
    String timerequired,
    String translator,
    String typicalagerange,
    String uploaddate,
    String url,
    Float version,
    String video,
    Integer width,
    String workexample
  ) {
    this.about = about;
    this.accessibilityapi = accessibilityapi;
    this.accessibilitycontrol = accessibilitycontrol;
    this.accessibilityfeature = accessibilityfeature;
    this.accessibilityhazard = accessibilityhazard;
    this.accountableperson = accountableperson;
    this.additionaltype = additionaltype;
    this.aggregaterating = aggregaterating;
    this.alternatename = alternatename;
    this.alternativeheadline = alternativeheadline;
    this.associatedarticle = associatedarticle;
    this.associatedmedia = associatedmedia;
    this.audience = audience;
    this.audio = audio;
    this.author = author;
    this.award = award;
    this.bitrate = bitrate;
    this.caption = caption;
    this.character = character;
    this.citation = citation;
    this.comment = comment;
    this.commentcount = commentcount;
    this.contentlocation = contentlocation;
    this.contentrating = contentrating;
    this.contentsize = contentsize;
    this.contenturl = contenturl;
    this.contributor = contributor;
    this.copyrightholder = copyrightholder;
    this.copyrightyear = copyrightyear;
    this.creator = creator;
    this.datecreated = datecreated;
    this.datemodified = datemodified;
    this.datepublished = datepublished;
    this.description = description;
    this.diagram = diagram;
    this.discussionurl = discussionurl;
    this.duration = duration;
    this.editor = editor;
    this.educationalalignment = educationalalignment;
    this.educationaluse = educationaluse;
    this.embedurl = embedurl;
    this.encodescreativework = encodescreativework;
    this.encoding = encoding;
    this.encodingformat = encodingformat;
    this.exampleofwork = exampleofwork;
    this.exifdata = exifdata;
    this.expires = expires;
    this.fileformat = fileformat;
    this.genre = genre;
    this.haspart = haspart;
    this.headline = headline;
    this.height = height;
    this.image = image;
    this.inlanguage = inlanguage;
    this.interactionstatistic = interactionstatistic;
    this.interactivitytype = interactivitytype;
    this.isbasedonurl = isbasedonurl;
    this.isfamilyfriendly = isfamilyfriendly;
    this.ispartof = ispartof;
    this.keywords = keywords;
    this.learningresourcetype = learningresourcetype;
    this.license = license;
    this.locationcreated = locationcreated;
    this.logo = logo;
    this.mainentity = mainentity;
    this.mainentityofpage = mainentityofpage;
    this.mentions = mentions;
    this.name = name;
    this.offers = offers;
    this.photo = photo;
    this.playertype = playertype;
    this.position = position;
    this.potentialaction = potentialaction;
    this.primaryimageofpage = primaryimageofpage;
    this.producer = producer;
    this.productioncompany = productioncompany;
    this.provider = provider;
    this.publication = publication;
    this.publisher = publisher;
    this.publishingprinciples = publishingprinciples;
    this.recordedat = recordedat;
    this.regionsallowed = regionsallowed;
    this.releasedevent = releasedevent;
    this.representativeofpage = representativeofpage;
    this.requiressubscription = requiressubscription;
    this.review = review;
    this.sameas = sameas;
    this.schemaversion = schemaversion;
    this.screenshot = screenshot;
    this.sourceorganization = sourceorganization;
    this.text = text;
    this.thumbnail = thumbnail;
    this.thumbnailurl = thumbnailurl;
    this.timerequired = timerequired;
    this.translator = translator;
    this.typicalagerange = typicalagerange;
    this.uploaddate = uploaddate;
    this.url = url;
    this.version = version;
    this.video = video;
    this.width = width;
    this.workexample = workexample;
  }

  public ImageObject(JsonObject json) {
    ImageObjectConverter.fromJson(json, this);
  }

  public ImageObject(ImageObject other) {
    this.about = other.getAbout();
    this.accessibilityapi = other.getAccessibilityapi();
    this.accessibilitycontrol = other.getAccessibilitycontrol();
    this.accessibilityfeature = other.getAccessibilityfeature();
    this.accessibilityhazard = other.getAccessibilityhazard();
    this.accountableperson = other.getAccountableperson();
    this.additionaltype = other.getAdditionaltype();
    this.aggregaterating = other.getAggregaterating();
    this.alternatename = other.getAlternatename();
    this.alternativeheadline = other.getAlternativeheadline();
    this.associatedarticle = other.getAssociatedarticle();
    this.associatedmedia = other.getAssociatedmedia();
    this.audience = other.getAudience();
    this.audio = other.getAudio();
    this.author = other.getAuthor();
    this.award = other.getAward();
    this.bitrate = other.getBitrate();
    this.caption = other.getCaption();
    this.character = other.getCharacter();
    this.citation = other.getCitation();
    this.comment = other.getComment();
    this.commentcount = other.getCommentcount();
    this.contentlocation = other.getContentlocation();
    this.contentrating = other.getContentrating();
    this.contentsize = other.getContentsize();
    this.contenturl = other.getContenturl();
    this.contributor = other.getContributor();
    this.copyrightholder = other.getCopyrightholder();
    this.copyrightyear = other.getCopyrightyear();
    this.creator = other.getCreator();
    this.datecreated = other.getDatecreated();
    this.datemodified = other.getDatemodified();
    this.datepublished = other.getDatepublished();
    this.description = other.getDescription();
    this.diagram = other.getDiagram();
    this.discussionurl = other.getDiscussionurl();
    this.duration = other.getDuration();
    this.editor = other.getEditor();
    this.educationalalignment = other.getEducationalalignment();
    this.educationaluse = other.getEducationaluse();
    this.embedurl = other.getEmbedurl();
    this.encodescreativework = other.getEncodescreativework();
    this.encoding = other.getEncoding();
    this.encodingformat = other.getEncodingformat();
    this.exampleofwork = other.getExampleofwork();
    this.exifdata = other.getExifdata();
    this.expires = other.getExpires();
    this.fileformat = other.getFileformat();
    this.genre = other.getGenre();
    this.haspart = other.getHaspart();
    this.headline = other.getHeadline();
    this.height = other.getHeight();
    this.image = other.getImage();
    this.inlanguage = other.getInlanguage();
    this.interactionstatistic = other.getInteractionstatistic();
    this.interactivitytype = other.getInteractivitytype();
    this.isbasedonurl = other.getIsbasedonurl();
    this.isfamilyfriendly = other.isIsfamilyfriendly();
    this.ispartof = other.getIspartof();
    this.keywords = other.getKeywords();
    this.learningresourcetype = other.getLearningresourcetype();
    this.license = other.getLicense();
    this.locationcreated = other.getLocationcreated();
    this.logo = other.getLogo();
    this.mainentity = other.getMainentity();
    this.mainentityofpage = other.getMainentityofpage();
    this.mentions = other.getMentions();
    this.name = other.getName();
    this.offers = other.getOffers();
    this.photo = other.getPhoto();
    this.playertype = other.getPlayertype();
    this.position = other.getPosition();
    this.potentialaction = other.getPotentialaction();
    this.primaryimageofpage = other.getPrimaryimageofpage();
    this.producer = other.getProducer();
    this.productioncompany = other.getProductioncompany();
    this.provider = other.getProvider();
    this.publication = other.getPublication();
    this.publisher = other.getPublisher();
    this.publishingprinciples = other.getPublishingprinciples();
    this.recordedat = other.getRecordedat();
    this.regionsallowed = other.getRegionsallowed();
    this.releasedevent = other.getReleasedevent();
    this.representativeofpage = other.isRepresentativeofpage();
    this.requiressubscription = other.isRequiressubscription();
    this.review = other.getReview();
    this.sameas = other.getSameas();
    this.schemaversion = other.getSchemaversion();
    this.screenshot = other.getScreenshot();
    this.sourceorganization = other.getSourceorganization();
    this.text = other.getText();
    this.thumbnail = other.getThumbnail();
    this.thumbnailurl = other.getThumbnailurl();
    this.timerequired = other.getTimerequired();
    this.translator = other.getTranslator();
    this.typicalagerange = other.getTypicalagerange();
    this.uploaddate = other.getUploaddate();
    this.url = other.getUrl();
    this.version = other.getVersion();
    this.video = other.getVideo();
    this.width = other.getWidth();
    this.workexample = other.getWorkexample();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    ImageObjectConverter.toJson(this, json);
    return json;
  }

  @Fluent public ImageObject setAbout(String about){
    this.about = about;
    return this;
  }
  public String getAbout() {
    return this.about;
  }

  @Fluent public ImageObject setAccessibilityapi(String accessibilityapi){
    this.accessibilityapi = accessibilityapi;
    return this;
  }
  public String getAccessibilityapi() {
    return this.accessibilityapi;
  }

  @Fluent public ImageObject setAccessibilitycontrol(String accessibilitycontrol){
    this.accessibilitycontrol = accessibilitycontrol;
    return this;
  }
  public String getAccessibilitycontrol() {
    return this.accessibilitycontrol;
  }

  @Fluent public ImageObject setAccessibilityfeature(String accessibilityfeature){
    this.accessibilityfeature = accessibilityfeature;
    return this;
  }
  public String getAccessibilityfeature() {
    return this.accessibilityfeature;
  }

  @Fluent public ImageObject setAccessibilityhazard(String accessibilityhazard){
    this.accessibilityhazard = accessibilityhazard;
    return this;
  }
  public String getAccessibilityhazard() {
    return this.accessibilityhazard;
  }

  @Fluent public ImageObject setAccountableperson(String accountableperson){
    this.accountableperson = accountableperson;
    return this;
  }
  public String getAccountableperson() {
    return this.accountableperson;
  }

  @Fluent public ImageObject setAdditionaltype(String additionaltype){
    this.additionaltype = additionaltype;
    return this;
  }
  public String getAdditionaltype() {
    return this.additionaltype;
  }

  @Fluent public ImageObject setAggregaterating(String aggregaterating){
    this.aggregaterating = aggregaterating;
    return this;
  }
  public String getAggregaterating() {
    return this.aggregaterating;
  }

  @Fluent public ImageObject setAlternatename(String alternatename){
    this.alternatename = alternatename;
    return this;
  }
  public String getAlternatename() {
    return this.alternatename;
  }

  @Fluent public ImageObject setAlternativeheadline(String alternativeheadline){
    this.alternativeheadline = alternativeheadline;
    return this;
  }
  public String getAlternativeheadline() {
    return this.alternativeheadline;
  }

  @Fluent public ImageObject setAssociatedarticle(String associatedarticle){
    this.associatedarticle = associatedarticle;
    return this;
  }
  public String getAssociatedarticle() {
    return this.associatedarticle;
  }

  @Fluent public ImageObject setAssociatedmedia(String associatedmedia){
    this.associatedmedia = associatedmedia;
    return this;
  }
  public String getAssociatedmedia() {
    return this.associatedmedia;
  }

  @Fluent public ImageObject setAudience(String audience){
    this.audience = audience;
    return this;
  }
  public String getAudience() {
    return this.audience;
  }

  @Fluent public ImageObject setAudio(String audio){
    this.audio = audio;
    return this;
  }
  public String getAudio() {
    return this.audio;
  }

  @Fluent public ImageObject setAuthor(String author){
    this.author = author;
    return this;
  }
  public String getAuthor() {
    return this.author;
  }

  @Fluent public ImageObject setAward(String award){
    this.award = award;
    return this;
  }
  public String getAward() {
    return this.award;
  }

  @Fluent public ImageObject setBitrate(Integer bitrate){
    this.bitrate = bitrate;
    return this;
  }
  public Integer getBitrate() {
    return this.bitrate;
  }

  @Fluent public ImageObject setCaption(String caption){
    this.caption = caption;
    return this;
  }
  public String getCaption() {
    return this.caption;
  }

  @Fluent public ImageObject setCharacter(String character){
    this.character = character;
    return this;
  }
  public String getCharacter() {
    return this.character;
  }

  @Fluent public ImageObject setCitation(String citation){
    this.citation = citation;
    return this;
  }
  public String getCitation() {
    return this.citation;
  }

  @Fluent public ImageObject setComment(String comment){
    this.comment = comment;
    return this;
  }
  public String getComment() {
    return this.comment;
  }

  @Fluent public ImageObject setCommentcount(Integer commentcount){
    this.commentcount = commentcount;
    return this;
  }
  public Integer getCommentcount() {
    return this.commentcount;
  }

  @Fluent public ImageObject setContentlocation(String contentlocation){
    this.contentlocation = contentlocation;
    return this;
  }
  public String getContentlocation() {
    return this.contentlocation;
  }

  @Fluent public ImageObject setContentrating(String contentrating){
    this.contentrating = contentrating;
    return this;
  }
  public String getContentrating() {
    return this.contentrating;
  }

  @Fluent public ImageObject setContentsize(String contentsize){
    this.contentsize = contentsize;
    return this;
  }
  public String getContentsize() {
    return this.contentsize;
  }

  @Fluent public ImageObject setContenturl(String contenturl){
    this.contenturl = contenturl;
    return this;
  }
  public String getContenturl() {
    return this.contenturl;
  }

  @Fluent public ImageObject setContributor(String contributor){
    this.contributor = contributor;
    return this;
  }
  public String getContributor() {
    return this.contributor;
  }

  @Fluent public ImageObject setCopyrightholder(String copyrightholder){
    this.copyrightholder = copyrightholder;
    return this;
  }
  public String getCopyrightholder() {
    return this.copyrightholder;
  }

  @Fluent public ImageObject setCopyrightyear(Float copyrightyear){
    this.copyrightyear = copyrightyear;
    return this;
  }
  public Float getCopyrightyear() {
    return this.copyrightyear;
  }

  @Fluent public ImageObject setCreator(String creator){
    this.creator = creator;
    return this;
  }
  public String getCreator() {
    return this.creator;
  }

  @Fluent public ImageObject setDatecreated(String datecreated){
    this.datecreated = datecreated;
    return this;
  }
  public String getDatecreated() {
    return this.datecreated;
  }

  @Fluent public ImageObject setDatemodified(String datemodified){
    this.datemodified = datemodified;
    return this;
  }
  public String getDatemodified() {
    return this.datemodified;
  }

  @Fluent public ImageObject setDatepublished(String datepublished){
    this.datepublished = datepublished;
    return this;
  }
  public String getDatepublished() {
    return this.datepublished;
  }

  @Fluent public ImageObject setDescription(String description){
    this.description = description;
    return this;
  }
  public String getDescription() {
    return this.description;
  }

  @Fluent public ImageObject setDiagram(String diagram){
    this.diagram = diagram;
    return this;
  }
  public String getDiagram() {
    return this.diagram;
  }

  @Fluent public ImageObject setDiscussionurl(String discussionurl){
    this.discussionurl = discussionurl;
    return this;
  }
  public String getDiscussionurl() {
    return this.discussionurl;
  }

  @Fluent public ImageObject setDuration(String duration){
    this.duration = duration;
    return this;
  }
  public String getDuration() {
    return this.duration;
  }

  @Fluent public ImageObject setEditor(String editor){
    this.editor = editor;
    return this;
  }
  public String getEditor() {
    return this.editor;
  }

  @Fluent public ImageObject setEducationalalignment(String educationalalignment){
    this.educationalalignment = educationalalignment;
    return this;
  }
  public String getEducationalalignment() {
    return this.educationalalignment;
  }

  @Fluent public ImageObject setEducationaluse(String educationaluse){
    this.educationaluse = educationaluse;
    return this;
  }
  public String getEducationaluse() {
    return this.educationaluse;
  }

  @Fluent public ImageObject setEmbedurl(String embedurl){
    this.embedurl = embedurl;
    return this;
  }
  public String getEmbedurl() {
    return this.embedurl;
  }

  @Fluent public ImageObject setEncodescreativework(String encodescreativework){
    this.encodescreativework = encodescreativework;
    return this;
  }
  public String getEncodescreativework() {
    return this.encodescreativework;
  }

  @Fluent public ImageObject setEncoding(String encoding){
    this.encoding = encoding;
    return this;
  }
  public String getEncoding() {
    return this.encoding;
  }

  @Fluent public ImageObject setEncodingformat(String encodingformat){
    this.encodingformat = encodingformat;
    return this;
  }
  public String getEncodingformat() {
    return this.encodingformat;
  }

  @Fluent public ImageObject setExampleofwork(String exampleofwork){
    this.exampleofwork = exampleofwork;
    return this;
  }
  public String getExampleofwork() {
    return this.exampleofwork;
  }

  @Fluent public ImageObject setExifdata(String exifdata){
    this.exifdata = exifdata;
    return this;
  }
  public String getExifdata() {
    return this.exifdata;
  }

  @Fluent public ImageObject setExpires(String expires){
    this.expires = expires;
    return this;
  }
  public String getExpires() {
    return this.expires;
  }

  @Fluent public ImageObject setFileformat(String fileformat){
    this.fileformat = fileformat;
    return this;
  }
  public String getFileformat() {
    return this.fileformat;
  }

  @Fluent public ImageObject setGenre(String genre){
    this.genre = genre;
    return this;
  }
  public String getGenre() {
    return this.genre;
  }

  @Fluent public ImageObject setHaspart(String haspart){
    this.haspart = haspart;
    return this;
  }
  public String getHaspart() {
    return this.haspart;
  }

  @Fluent public ImageObject setHeadline(String headline){
    this.headline = headline;
    return this;
  }
  public String getHeadline() {
    return this.headline;
  }

  @Fluent public ImageObject setHeight(Integer height){
    this.height = height;
    return this;
  }
  public Integer getHeight() {
    return this.height;
  }

  @Fluent public ImageObject setImage(String image){
    this.image = image;
    return this;
  }
  public String getImage() {
    return this.image;
  }

  @Fluent public ImageObject setInlanguage(String inlanguage){
    this.inlanguage = inlanguage;
    return this;
  }
  public String getInlanguage() {
    return this.inlanguage;
  }

  @Fluent public ImageObject setInteractionstatistic(Integer interactionstatistic){
    this.interactionstatistic = interactionstatistic;
    return this;
  }
  public Integer getInteractionstatistic() {
    return this.interactionstatistic;
  }

  @Fluent public ImageObject setInteractivitytype(String interactivitytype){
    this.interactivitytype = interactivitytype;
    return this;
  }
  public String getInteractivitytype() {
    return this.interactivitytype;
  }

  @Fluent public ImageObject setIsbasedonurl(String isbasedonurl){
    this.isbasedonurl = isbasedonurl;
    return this;
  }
  public String getIsbasedonurl() {
    return this.isbasedonurl;
  }

  @Fluent public ImageObject setIsfamilyfriendly(Boolean isfamilyfriendly){
    this.isfamilyfriendly = isfamilyfriendly;
    return this;
  }
  public Boolean isIsfamilyfriendly() {
    return this.isfamilyfriendly;
  }

  @Fluent public ImageObject setIspartof(String ispartof){
    this.ispartof = ispartof;
    return this;
  }
  public String getIspartof() {
    return this.ispartof;
  }

  @Fluent public ImageObject setKeywords(String keywords){
    this.keywords = keywords;
    return this;
  }
  public String getKeywords() {
    return this.keywords;
  }

  @Fluent public ImageObject setLearningresourcetype(String learningresourcetype){
    this.learningresourcetype = learningresourcetype;
    return this;
  }
  public String getLearningresourcetype() {
    return this.learningresourcetype;
  }

  @Fluent public ImageObject setLicense(String license){
    this.license = license;
    return this;
  }
  public String getLicense() {
    return this.license;
  }

  @Fluent public ImageObject setLocationcreated(String locationcreated){
    this.locationcreated = locationcreated;
    return this;
  }
  public String getLocationcreated() {
    return this.locationcreated;
  }

  @Fluent public ImageObject setLogo(String logo){
    this.logo = logo;
    return this;
  }
  public String getLogo() {
    return this.logo;
  }

  @Fluent public ImageObject setMainentity(String mainentity){
    this.mainentity = mainentity;
    return this;
  }
  public String getMainentity() {
    return this.mainentity;
  }

  @Fluent public ImageObject setMainentityofpage(String mainentityofpage){
    this.mainentityofpage = mainentityofpage;
    return this;
  }
  public String getMainentityofpage() {
    return this.mainentityofpage;
  }

  @Fluent public ImageObject setMentions(String mentions){
    this.mentions = mentions;
    return this;
  }
  public String getMentions() {
    return this.mentions;
  }

  @Fluent public ImageObject setName(String name){
    this.name = name;
    return this;
  }
  public String getName() {
    return this.name;
  }

  @Fluent public ImageObject setOffers(String offers){
    this.offers = offers;
    return this;
  }
  public String getOffers() {
    return this.offers;
  }

  @Fluent public ImageObject setPhoto(String photo){
    this.photo = photo;
    return this;
  }
  public String getPhoto() {
    return this.photo;
  }

  @Fluent public ImageObject setPlayertype(String playertype){
    this.playertype = playertype;
    return this;
  }
  public String getPlayertype() {
    return this.playertype;
  }

  @Fluent public ImageObject setPosition(String position){
    this.position = position;
    return this;
  }
  public String getPosition() {
    return this.position;
  }

  @Fluent public ImageObject setPotentialaction(String potentialaction){
    this.potentialaction = potentialaction;
    return this;
  }
  public String getPotentialaction() {
    return this.potentialaction;
  }

  @Fluent public ImageObject setPrimaryimageofpage(String primaryimageofpage){
    this.primaryimageofpage = primaryimageofpage;
    return this;
  }
  public String getPrimaryimageofpage() {
    return this.primaryimageofpage;
  }

  @Fluent public ImageObject setProducer(String producer){
    this.producer = producer;
    return this;
  }
  public String getProducer() {
    return this.producer;
  }

  @Fluent public ImageObject setProductioncompany(String productioncompany){
    this.productioncompany = productioncompany;
    return this;
  }
  public String getProductioncompany() {
    return this.productioncompany;
  }

  @Fluent public ImageObject setProvider(String provider){
    this.provider = provider;
    return this;
  }
  public String getProvider() {
    return this.provider;
  }

  @Fluent public ImageObject setPublication(String publication){
    this.publication = publication;
    return this;
  }
  public String getPublication() {
    return this.publication;
  }

  @Fluent public ImageObject setPublisher(String publisher){
    this.publisher = publisher;
    return this;
  }
  public String getPublisher() {
    return this.publisher;
  }

  @Fluent public ImageObject setPublishingprinciples(String publishingprinciples){
    this.publishingprinciples = publishingprinciples;
    return this;
  }
  public String getPublishingprinciples() {
    return this.publishingprinciples;
  }

  @Fluent public ImageObject setRecordedat(String recordedat){
    this.recordedat = recordedat;
    return this;
  }
  public String getRecordedat() {
    return this.recordedat;
  }

  @Fluent public ImageObject setRegionsallowed(String regionsallowed){
    this.regionsallowed = regionsallowed;
    return this;
  }
  public String getRegionsallowed() {
    return this.regionsallowed;
  }

  @Fluent public ImageObject setReleasedevent(String releasedevent){
    this.releasedevent = releasedevent;
    return this;
  }
  public String getReleasedevent() {
    return this.releasedevent;
  }

  @Fluent public ImageObject setRepresentativeofpage(Boolean representativeofpage){
    this.representativeofpage = representativeofpage;
    return this;
  }
  public Boolean isRepresentativeofpage() {
    return this.representativeofpage;
  }

  @Fluent public ImageObject setRequiressubscription(Boolean requiressubscription){
    this.requiressubscription = requiressubscription;
    return this;
  }
  public Boolean isRequiressubscription() {
    return this.requiressubscription;
  }

  @Fluent public ImageObject setReview(String review){
    this.review = review;
    return this;
  }
  public String getReview() {
    return this.review;
  }

  @Fluent public ImageObject setSameas(String sameas){
    this.sameas = sameas;
    return this;
  }
  public String getSameas() {
    return this.sameas;
  }

  @Fluent public ImageObject setSchemaversion(String schemaversion){
    this.schemaversion = schemaversion;
    return this;
  }
  public String getSchemaversion() {
    return this.schemaversion;
  }

  @Fluent public ImageObject setScreenshot(String screenshot){
    this.screenshot = screenshot;
    return this;
  }
  public String getScreenshot() {
    return this.screenshot;
  }

  @Fluent public ImageObject setSourceorganization(String sourceorganization){
    this.sourceorganization = sourceorganization;
    return this;
  }
  public String getSourceorganization() {
    return this.sourceorganization;
  }

  @Fluent public ImageObject setText(String text){
    this.text = text;
    return this;
  }
  public String getText() {
    return this.text;
  }

  @Fluent public ImageObject setThumbnail(String thumbnail){
    this.thumbnail = thumbnail;
    return this;
  }
  public String getThumbnail() {
    return this.thumbnail;
  }

  @Fluent public ImageObject setThumbnailurl(String thumbnailurl){
    this.thumbnailurl = thumbnailurl;
    return this;
  }
  public String getThumbnailurl() {
    return this.thumbnailurl;
  }

  @Fluent public ImageObject setTimerequired(String timerequired){
    this.timerequired = timerequired;
    return this;
  }
  public String getTimerequired() {
    return this.timerequired;
  }

  @Fluent public ImageObject setTranslator(String translator){
    this.translator = translator;
    return this;
  }
  public String getTranslator() {
    return this.translator;
  }

  @Fluent public ImageObject setTypicalagerange(String typicalagerange){
    this.typicalagerange = typicalagerange;
    return this;
  }
  public String getTypicalagerange() {
    return this.typicalagerange;
  }

  @Fluent public ImageObject setUploaddate(String uploaddate){
    this.uploaddate = uploaddate;
    return this;
  }
  public String getUploaddate() {
    return this.uploaddate;
  }

  @Fluent public ImageObject setUrl(String url){
    this.url = url;
    return this;
  }
  public String getUrl() {
    return this.url;
  }

  @Fluent public ImageObject setVersion(Float version){
    this.version = version;
    return this;
  }
  public Float getVersion() {
    return this.version;
  }

  @Fluent public ImageObject setVideo(String video){
    this.video = video;
    return this;
  }
  public String getVideo() {
    return this.video;
  }

  @Fluent public ImageObject setWidth(Integer width){
    this.width = width;
    return this;
  }
  public Integer getWidth() {
    return this.width;
  }

  @Fluent public ImageObject setWorkexample(String workexample){
    this.workexample = workexample;
    return this;
  }
  public String getWorkexample() {
    return this.workexample;
  }

}