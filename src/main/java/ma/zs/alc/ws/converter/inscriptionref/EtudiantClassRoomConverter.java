package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.classroom.ClassRoomConverter;

import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.bean.core.inscription.Etudiant;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantClassRoomDto;

@Component
public class EtudiantClassRoomConverter extends AbstractConverter<EtudiantClassRoom, EtudiantClassRoomDto> {

    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private ClassRoomConverter classRoomConverter ;
    private boolean classRoom;
    private boolean etudiant;

    public  EtudiantClassRoomConverter() {
        super(EtudiantClassRoom.class, EtudiantClassRoomDto.class);
        init(true);
    }

    @Override
    public EtudiantClassRoom toItem(EtudiantClassRoomDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtudiantClassRoom item = new EtudiantClassRoom();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getClassRoom() != null && dto.getClassRoom().getId() != null){
                item.setClassRoom(new ClassRoom());
                item.getClassRoom().setId(dto.getClassRoom().getId());
                item.getClassRoom().setLibelle(dto.getClassRoom().getLibelle());
            }

            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }




        return item;
        }
    }

    @Override
    public EtudiantClassRoomDto toDto(EtudiantClassRoom item) {
        if (item == null) {
            return null;
        } else {
            EtudiantClassRoomDto dto = new EtudiantClassRoomDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(this.classRoom && item.getClassRoom()!=null) {
                dto.setClassRoom(classRoomConverter.toDto(item.getClassRoom())) ;

            }
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }


        return dto;
        }
    }

    public void copy(EtudiantClassRoomDto dto, EtudiantClassRoom t) {
    super.copy(dto, t);
    if (dto.getClassRoom() != null)
        classRoomConverter.copy(dto.getClassRoom(), t.getClassRoom());
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    }



    public void initObject(boolean value) {
        this.classRoom = value;
        this.etudiant = value;
    }


    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public ClassRoomConverter getClassRoomConverter(){
        return this.classRoomConverter;
    }
    public void setClassRoomConverter(ClassRoomConverter classRoomConverter ){
        this.classRoomConverter = classRoomConverter;
    }
    public boolean  isClassRoom(){
        return this.classRoom;
    }
    public void  setClassRoom(boolean classRoom){
        this.classRoom = classRoom;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
    }
}
