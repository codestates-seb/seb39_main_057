package com.courseori.server.participants;

import com.courseori.server.item.entity.Item;
import com.courseori.server.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participants {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "participants_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "16"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    private Long participantsId;

    private int type;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    @JsonBackReference
    private Item item;

    private Long createdAt = new Date().getTime();
    private Long modifiedAt = new Date().getTime();

    public Participants(int type, Member member, Item item) {
        this.type = type;
        this.member = member;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Participants{ " +
                "participantsId= " + participantsId +
                ", type= " + type +
                ", member= " + member.getMemberId() +
                " }";
    }
}
