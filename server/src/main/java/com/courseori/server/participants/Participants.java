package com.courseori.server.participants;

import com.courseori.server.item.entity.Item;
import com.courseori.server.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantsId;

    private int type;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    @JsonBackReference
    private Item item;

    private Date createdAt = new Date();
    private Date modifiedAt = new Date();

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
