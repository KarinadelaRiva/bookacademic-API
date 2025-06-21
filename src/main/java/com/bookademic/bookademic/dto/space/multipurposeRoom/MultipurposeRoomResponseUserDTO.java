package com.bookademic.bookademic.dto.space.multipurposeRoom;

import com.bookademic.bookademic.dto.space.SpaceResponseAdminDTO;
import com.bookademic.bookademic.dto.space.SpaceResponseUserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MultipurposeRoomResponseUserDTO extends SpaceResponseUserDTO {

    @Schema(
        description = "Indicates if the room has audio-visual equipment",
        example = "true"
    )
    private Boolean hasAudioVisualEquipment;

    @Schema(
        description = "Indicates if the room has stage",
        example = "false"
    )
    private Boolean hasStage;
}
