package com.bookademic.bookademic.dto.space.multipurposeRoom;

import com.bookademic.bookademic.dto.space.SpaceCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MultipurposeRoomCreateDTO extends SpaceCreateDTO {

    @Schema(
        description = "Indicates if the room has audio-visual equipment",
        example = "true",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasAudioVisualEquipment = false;

    @Schema(
        description = "Indicates if the room has stage",
        example = "false",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasStage = false;
}
